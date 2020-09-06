/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Units;


import Test_Units.treeUnits.Nodo;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

/**
 *
 * @author Domain
 */
public class TreeTest {
    public static void main(String[] args){
        //Nodos que utiliza el arbol
        Nodo nodox1 = new Nodo("Puto");
        Nodo nodox2 = new Nodo("Lets");
        Nodo nodox3 = new Nodo("FUUUCKING");
        Nodo nodox4 = new Nodo("GOOOOOOOOOOOOO");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(nodox1);
        DefaultMutableTreeNode node4 = new DefaultMutableTreeNode(nodox2);
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(nodox3);
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(nodox4);
        JLabel selectedLabel;
        
        node.add(node4);
        node4.add(node1);
        node1.add(node2);
        
        //Frame simple con un arbol
        JFrame frame = new JFrame("Tree Test");
        JTree tree = new JTree(node);
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUp arbol
        
        frame.add(tree);
        
        frame.add(new JScrollPane(tree));
        
        //SHIT
        selectedLabel = new JLabel();
        frame.add(selectedLabel, BorderLayout.SOUTH);
        
        
        ImageIcon imageIcon = new ImageIcon(TreeTest.class.getResource("comentario.png"));
        ImageIcon imageIcon2 = new ImageIcon(TreeTest.class.getResource("lobo.png"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);
        renderer.setOpenIcon(imageIcon2);
        tree.setCellRenderer(renderer);
        
        
        //Sacar descripción por selección.
        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
        
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                       tree.getLastSelectedPathComponent();
            
            if(node==null)return;
            
            Nodo n = (Nodo)node.getUserObject();
            System.out.println(n.papara());
        }
        });
        
        
        
        //Run this shit
        frame.setVisible(true);
        
        
    }
}
