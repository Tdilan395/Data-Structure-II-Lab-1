/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;


import java.awt.Color;
import java.time.LocalTime;
import java.util.ArrayList;
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
    
    
    public GUI_Tree(String title, Nodo n_root,int width){
        super(title);
        this.width=width;
        this.height=width/16*9;
        root= new DefaultMutableTreeNode(n_root);
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
        String varTypeOptions[]= {"Var1","Var2","Var3"}; 
        varType = new JComboBox(varTypeOptions);
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

                    DefaultListModel modelo = (DefaultListModel)tree.getModel();
                    if(tree.getSelectedIndex()==0){
                        nodo.etiquetaSelection=false;
                    }
                    
                    modelo.clear();
                    if(nodo.getFather()!=null)nodo.getFather().etiquetaSelection=true;
                    modelo.addElement(nodo.getFather());
                    for (Nodo col : nodo.getLinks()) {
                        modelo.addElement(col);
                    }
                    
                }
        	past = now;
            }
        });
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
