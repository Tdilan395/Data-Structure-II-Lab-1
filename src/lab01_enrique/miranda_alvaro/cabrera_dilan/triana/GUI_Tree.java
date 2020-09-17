/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;


import java.awt.Color;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Domain
 */
public class GUI_Tree extends JFrame{
    private DefaultMutableTreeNode root;
    private JPanel panel;
    private int width,height;
    private JTextArea description;
    private JScrollPane treeBar;
    private JScrollPane descripcionBar;
    private JButton search;
    private JButton searchOwner;
    private JTextField searchLabel;
    private JTextField routeLabel;
    private JList tree;
    private JComboBox nodoType;
    private JComboBox varType;
    private long now,past;
    private Nodo n_root;
    private DefaultComboBoxModel search_atributes[];
    
    
    public GUI_Tree(String title, Nodo n_root,int width){
        super(title);
        this.width=width;
        this.height=width/16*9;
        root= new DefaultMutableTreeNode(n_root);
        this.n_root = n_root;
        DefaultListModel model = new DefaultListModel();
        for (Nodo nodo:n_root.getLinks()) {
            model.addElement(nodo);
        }
        tree = new JList(model);
        treeBar=new JScrollPane();
        description= new JTextArea();
        search = new JButton("Buscar");
        searchOwner = new JButton("Buscar Usuario");
        searchLabel = new  JTextField();
        String nodoTypeOptions[]= {"Users","Post","Comment"}; 
        nodoType = new JComboBox(nodoTypeOptions);
        varType = new JComboBox();
        search_atributes = new DefaultComboBoxModel[3];
        initComboBoxAtributes();
        varType.setModel(search_atributes[nodoType.getSelectedIndex()]);
        descripcionBar= new JScrollPane();
        panel = new JPanel();
        past=System.nanoTime();
        init();
    }

    private void init(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        description.setEditable(false);
        setSize(width, height);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
        
        descripcionBar.setBounds(width/2-50, 60, width/2-100, height/2);
        treeBar.setBounds(5, 60, width/2-100, height/2);
        searchLabel.setBounds(10, 10, 80, 25);
        searchLabel.setBackground(Color.WHITE);
        nodoType.setBounds(110, 10, 80, 25);
        varType.setBounds(200, 10, 80, 25);
        search.setBounds(290, 10, 80, 25);
        searchOwner.setBounds(width/2-50, 65+height/2, 80, 25);
        
        panel.add(descripcionBar);
        panel.add(treeBar);
        panel.add(searchLabel);
        panel.add(nodoType);
        panel.add(varType);
        panel.add(search);
        panel.add(searchOwner);
        
        searchOwner.setEnabled(false);
        descripcionBar.setViewportView(description);
        treeBar.setViewportView(tree);
        
        this.setResizable(false);
        this.setVisible(true);
        
        nodoType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                varType.setModel(search_atributes[nodoType.getSelectedIndex()]);
            }
        });
        
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!searchLabel.getText().isEmpty()) {
                    description.setText("");
                    switch ((String) nodoType.getSelectedItem()) {
                        case "Users":
                            ArrayList<Nodo> u = n_root.search((String) varType.getSelectedItem(), searchLabel.getText());
                            if (!u.isEmpty()) {
                                description.append(u.get(0).printInfo());
                            } else {
                                description.append("No se encontró usuario buscado por " + varType.getSelectedItem() + ": " + searchLabel.getText() + "\n");
                            }
                            searchLabel.setText("");
                            break;
                        case "Post":
                            ArrayList<Nodo> p = n_root.searchPost((String) varType.getSelectedItem(), searchLabel.getText());
                            if (!p.isEmpty()) {
                                description.append(p.get(0).printInfo());
                            } else {
                                description.append("No se encontró post buscado por " + varType.getSelectedItem() + ": " + searchLabel.getText() + "\n");
                            }
                            break;
                        case "Comment":
                            ArrayList<Nodo> c = n_root.searchComment((String) varType.getSelectedItem(), searchLabel.getText());
                            if (!c.isEmpty()) {
                                description.append(c.get(0).printInfo());
                            } else {
                                description.append("No se encontró comentario buscado por " + varType.getSelectedItem() + ": " + searchLabel.getText() + "\n");
                            }
                            break;

                    }
                }
            }
        });
        
        tree.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            
            Nodo n = (Nodo)tree.getSelectedValue();
            if(n==null)return;
            if(n instanceof Comment)searchOwner.setEnabled(true);
            else searchOwner.setEnabled(false);
            description.setText(n.printInfo());
        }
        });
        
        
        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                now = System.nanoTime();
                
                System.out.println("Run Test00 "+(now-past));
                if(now-past<=250000000){
                    Nodo nodo = (Nodo)tree.getSelectedValue();

                    if(tree.getSelectedIndex()==0){
                        nodo.etiquetaSelection=false;
                    }
                    
                    showList(nodo);
                }
        	past = now;
            }
        });
    }
    
    private void showList(Nodo nodo) {
        DefaultListModel modelo = (DefaultListModel)tree.getModel();
        modelo.clear();
        if (nodo.getFather() != null) {
            nodo.getFather().etiquetaSelection = true;
        }
        modelo.addElement(nodo.getFather());
        for (Nodo col : nodo.getLinks()) {
            modelo.addElement(col);
        }
    }
    
    private void initComboBoxAtributes() {
        this.search_atributes[0] = new DefaultComboBoxModel();
        this.search_atributes[0].addElement("id");
        this.search_atributes[0].addElement("name");
        this.search_atributes[0].addElement("username");
        this.search_atributes[0].addElement("email");
        this.search_atributes[0].addElement("dir-street");
        this.search_atributes[0].addElement("dir-suite");
        this.search_atributes[0].addElement("dir-city");
        this.search_atributes[0].addElement("dir-zipcode");
        this.search_atributes[0].addElement("geo-lat");
        this.search_atributes[0].addElement("geo-lng");
        this.search_atributes[0].addElement("phone");
        this.search_atributes[0].addElement("website");
        this.search_atributes[0].addElement("comp-name");
        this.search_atributes[0].addElement("comp-catchPhrase");
        this.search_atributes[0].addElement("comp-bs");
        this.search_atributes[1] = new DefaultComboBoxModel();
        this.search_atributes[1].addElement("userId");
        this.search_atributes[1].addElement("id");
        this.search_atributes[1].addElement("title");
        this.search_atributes[1].addElement("body");
        this.search_atributes[2] = new DefaultComboBoxModel();
        this.search_atributes[2].addElement("postId");
        this.search_atributes[2].addElement("id");
        this.search_atributes[2].addElement("name");
        this.search_atributes[2].addElement("email");
        this.search_atributes[2].addElement("body");
    }
    
    public void add(ArrayList<Nodo>nodos, DefaultMutableTreeNode root){
        DefaultMutableTreeNode j_Nodo;
        for (Nodo nodo : nodos) {
            j_Nodo= new DefaultMutableTreeNode(nodo);
            this.add(nodo.getLinks(), j_Nodo);
            root.add(j_Nodo); 
        }
    }

    public DefaultMutableTreeNode getRoot() {
        
        return root;
    }
    
    
    
}
