/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Units.treeUnits;


import java.awt.TextArea;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import lab01_enrique.miranda_alvaro.cabrera_dilan.triana.Nodo;

/**
 *
 * @author Domain
 */
public class GUI_Tree extends JFrame{
    private JTree tree;
    private DefaultMutableTreeNode root;
    private JLabel routeLabel;
    private TextArea a;
    private int width,height;
    
    

    public GUI_Tree(String title, Nodo n_root,int width, int height){
        super(title);
        root= new DefaultMutableTreeNode(n_root);
        tree = new JTree(root);
        a = new TextArea();
        a.setSize(100, height);
        this.width=width;
        this.height=height;
        init();
    }

    private void init(){
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new JScrollPane(tree));
        this.add(tree);
        this.setVisible(true);
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
