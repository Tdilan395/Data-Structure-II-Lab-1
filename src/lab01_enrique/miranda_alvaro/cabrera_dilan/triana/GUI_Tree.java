/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Domain
 */
public class GUI_Tree extends JFrame{
    private Nodo backRoot;
    private JPanel panel;
    private int width, height;
    private JTextArea description;
    private JScrollPane treeBar;
    private JScrollPane descripcionBar;
    private JButton search;
    private JButton filter;
    private JButton up,down;
    private JTextField searchLabel;
    private JTextField routeLabel;
    private JTextField matches;
    private JList tree;
    private JComboBox nodoType;
    private JComboBox varType;
    private JComboBox filterType;
    private NodoList searchResult;
    private long now,past;
    private Nodo n_root;
    private DefaultComboBoxModel search_atributes[];
    
    
    public GUI_Tree(String title, Nodo n_root,int width){
        super(title);
        this.width=width;
        this.height=width/16*9;
        this.n_root = n_root;
        searchResult = new NodoList();
        DefaultListModel model = new DefaultListModel();
        NodoList p = n_root.getLinks();
        while(p!=null){
            model.addElement(p.getObject());
            p=p.link;
        }
        tree = new JList(model);
        treeBar=new JScrollPane();
        description= new JTextArea();
        search = new JButton("Buscar");
        filter = new JButton("Filtrar");
        up=new JButton("🔼");
        down= new JButton("🔽");
        searchLabel = new  JTextField();
        up.setEnabled(false);
        down.setEnabled(false);
        matches = new JTextField();
        matches.setText("");
        routeLabel = new JTextField("Route:\\\\ Init");
        String[] basicTypeOptions= {"Users","Post","Comment"}; 
        nodoType = new JComboBox(basicTypeOptions);
        filterType= new JComboBox(basicTypeOptions);
        varType = new JComboBox();
        search_atributes = new DefaultComboBoxModel[3];
        initComboBoxAtributes();
        varType.setModel(search_atributes[nodoType.getSelectedIndex()]);
        descripcionBar= new JScrollPane();
        panel = new JPanel();
        past=System.nanoTime();
        init();
    }

    private void init() {
        description.setLineWrap(true);
        description.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        description.setWrapStyleWord(true);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        description.setEditable(false);
        routeLabel.setEditable(false);
        matches.setEditable(false);
        setSize(width, height);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
        
        descripcionBar.setBounds(width/2-50, 90, width/2-100, height/2);
        treeBar.setBounds(5, 90, width/2-100, height/2);
        down.setBounds(5+treeBar.getWidth()/2-80, 95+height/2, 50, 30);
        up.setBounds(5+treeBar.getWidth()/2+30, 95+height/2, 50, 30);
        matches.setBounds(5+treeBar.getWidth()/2-25, 95+height/2, 50, 30);
        routeLabel.setBounds(5, 60, width/2-100,25);
        searchLabel.setBounds(10, 10, 80, 25);
        searchLabel.setBackground(Color.WHITE);
        nodoType.setBounds(110, 10, 80, 25);
        varType.setBounds(200, 10, 80, 25);
        search.setBounds(290, 10, 80, 25);
        filter.setBounds(100,height-80,80, 25);
        filterType.setBounds(10, height-80,80, 25);
        
        matches.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        panel.add(descripcionBar);
        panel.add(treeBar);
        panel.add(up);
        panel.add(down);
        panel.add(matches);
        panel.add(routeLabel);
        panel.add(searchLabel);
        panel.add(nodoType);
        panel.add(varType);
        panel.add(filterType);
        panel.add(search);
        panel.add(filter);
        descripcionBar.setViewportView(description);
        treeBar.setViewportView(tree);

        this.setResizable(false);
        this.setVisible(true);

        nodoType.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                varType.setModel(search_atributes[nodoType.getSelectedIndex()]);
            }
        });
        
        filter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                DefaultListModel model = (DefaultListModel)tree.getModel();
                setEtiquetasFalse();
                model.clear();
                switch((String)filterType.getSelectedItem()){
                        case "Users":
                            showUsersModel(model);
                            break;
                        case "Post":
                            showPlaneModel(n_root,0,model);
                            break;
                        case "Comment":
                            showCommentsModel(model);
                            break;
                }
                
            }


        });
        
        search.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                if (!searchLabel.getText().isEmpty()) {
                    description.setText("");
                    switch ((String) nodoType.getSelectedItem()) {
                        case "Users":
                            searchResult = n_root.search((String) varType.getSelectedItem(), searchLabel.getText());
                            break;
                        case "Post":
                            searchResult = n_root.searchPost((String) varType.getSelectedItem(), searchLabel.getText());
                            break;
                        case "Comment":
                            searchResult = n_root.searchComment((String) varType.getSelectedItem(), searchLabel.getText());
                            break;
                    }

                    if (!searchResult.isEmpty()) {
                        description.append(((Nodo) searchResult.getNodo(0)).printInfo());
                        showList(((Nodo) searchResult.getNodo(0)).getFather());
                        matches.setText("1");
                    } else {
                        description.append("No se encontró "+ (String) nodoType.getSelectedItem() +" buscado por " + varType.getSelectedItem() + ": " + searchLabel.getText() + "\n");
                    }
                    searchLabel.setText("");
                    setPages();
                }
            }


        });
        
        up.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minus();
                String iValue = matches.getText().substring(0, indexOf(matches.getText(), "/"));
                int i = Integer.parseInt(iValue)-1;
                description.setText("");
                description.append(((Nodo) searchResult.getNodo(i)).printInfo());
                showList(((Nodo) searchResult.getNodo(i)).getFather());
            }
        });
        
        down.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plus();
                String iValue = matches.getText().substring(0, indexOf(matches.getText(), "/"));
                int i = Integer.parseInt(iValue)-1;
                description.setText("");
                description.append(((Nodo) searchResult.getNodo(i)).printInfo());
                showList(((Nodo) searchResult.getNodo(i)).getFather());
            }
        });
        
        tree.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            
            Nodo n = (Nodo)tree.getSelectedValue();
            if(n==null)return;
            
            description.setText(n.printInfo());
            searchResult = new NodoList();
            up.setEnabled(false);
            down.setEnabled(false);
            matches.setText("");
        }
        });
        
        
        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                now = System.nanoTime();
                
                //System.out.println("Run Test00 "+(now-past));
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
    
    private void setEtiquetasFalse() {
        if(backRoot!=null)backRoot.etiquetaSelection=false;
    }
    
    public void setRoute(Nodo nodo){
        Nodo p = nodo;
        String route="";
        
        while(p.getFather()!=null){
            route=(" → "+p.getSingleRoute()+route);
            p = p.getFather();
        }
        routeLabel.setText("Route:\\\\ Init"+route);
    }
    
    private void showList(Nodo nodo) {
        DefaultListModel modelo = (DefaultListModel)tree.getModel();
        modelo.clear();
        setRoute(nodo);
        if (nodo.getFather() != null) {
            setEtiquetasFalse();
            nodo.getFather().etiquetaSelection = true;
            backRoot = nodo.getFather();
        }
        modelo.addElement(nodo.getFather());
        NodoList p = nodo.getLinks();
        while(p!=null) {
            modelo.addElement(p.getObject());
            p=p.link;
        }
    }
    
    public void plus() {
        String iValue = matches.getText().substring(0, indexOf(matches.getText(), "/"));
        int i = Integer.parseInt(iValue);
        if (i >= searchResult.size() - 1) {
            down.setEnabled(false);
        }
        if (i == 1) {
            up.setEnabled(true);
        }
        matches.setText(String.valueOf(i + 1)+ "/" + searchResult.size());
    }

    public void minus() {
        String iValue = matches.getText().substring(0, indexOf(matches.getText(), "/"));
        int i = Integer.parseInt(iValue);
        if (i == 2) {
            up.setEnabled(false);
        }
        if (i == searchResult.size()) {
            down.setEnabled(true);
        }
        matches.setText(String.valueOf(i - 1) + "/" + searchResult.size());
    }
    
    private void setPages() {
        if (searchResult == null || searchResult.isEmpty()) {
            matches.setText("0");
        } else if (searchResult.size() == 1) {
            matches.setText("1");
        } else if (searchResult.size() > 1) {
            matches.setText("1/"+searchResult.size());
            down.setEnabled(true);
        }
    }
    
    private void initComboBoxAtributes() {
        this.search_atributes[0] = new DefaultComboBoxModel();
        this.search_atributes[0].addElement("id");
        this.search_atributes[0].addElement("name");
        this.search_atributes[0].addElement("username");
        this.search_atributes[0].addElement("email");
        this.search_atributes[0].addElement("city");
        this.search_atributes[0].addElement("phone");
        this.search_atributes[0].addElement("website");
        this.search_atributes[0].addElement("comp-name");
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

    private int indexOf(String text, String key) {
        
        for (int i = 0; i < text.length(); i++) {
            if(text.substring(i, i+1).equals(key))return i;
        }
        return -1;
    }
    
    private void showUsersModel(DefaultListModel model) {
        NodoList p = n_root.getLinks();
        while (p != null) {
            model.addElement(p.getObject());
            p = p.link;
        }
    }

    private void showPlaneModel(Nodo core, int i, DefaultListModel model) {
        if (i >= core.getLinks().size()) {
            return;
        }
        
        NodoList p = core.getLink(i).getLinks();
        while (p != null) {
            model.addElement(p.getObject());
            p = p.link;
        }
        
        showPlaneModel(core, i + 1, model);
    }

    private void showCommentsModel(DefaultListModel model) {
        NodoList p = n_root.getLinks();
        while (p != null) {
            showPlaneModel((Nodo) p.getObject(), 0, model);
            p = p.link;
        }
    }

}
