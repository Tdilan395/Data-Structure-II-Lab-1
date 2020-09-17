/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Units;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lab01_enrique.miranda_alvaro.cabrera_dilan.triana.*;

/**
 *
 * @author Enrique
 */
public class SearchInfo extends JFrame {

    ArrayList<Nodo> searchResult;
    private JButton next;
    private JButton previus;
    private JButton showTree;
    private JTextField number;
    private JPanel panel;
    private JLabel info;
    final int WIDTH = 600;
    final int HEIGTH = 300;

    public SearchInfo(ArrayList<Nodo> result) {
        ArrayList<Nodo> a = new ArrayList<>();
        User u = new User(1, null, null, null, null, null, null, null);
        Post p = new Post(2, null, null, 1);
        Comment c = new Comment(2, null, null, null, 2);
        a.add(u);
        a.add(p);
        a.add(c);
        int i;
        try {
            //i = result.size();
            i = a.size();
        } catch (Exception e) {
            i = 0;
        }
        setTitle("Resultados de busqueda - " + i);
        setSize(WIDTH, HEIGTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setResults(a);
    }

    private void init() {
        panel = new JPanel();
        panel.setLayout(null);

        previus = new JButton();
        previus.setText("<");
        previus.setBounds(WIDTH - 45 - 35 - 45 - 30 - 2, 225, 45, 23);
        previus.setEnabled(false);
        panel.add(previus);

        number = new JTextField();
        number.setEditable(false);
        number.setBounds(this.WIDTH - 35 - 45 - 30 - 1, 225, 35, 23);
        panel.add(number);

        next = new JButton();
        next.setText(">");
        next.setBounds(WIDTH - 30 - 45, 225, 45, 23);
        next.setVisible(true);
        panel.add(next);

        showTree = new JButton();
        showTree.setText("Mostrar");
        showTree.setBounds(30, 225, 80, 23);
        showTree.setVisible(true);
        panel.add(showTree);

        info = new JLabel();
        info.setBounds(30, 30, 540, 195);
        info.setBackground(Color.BLUE);
        panel.add(info);

        setPages();
        this.getContentPane().add(panel);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void setResults(ArrayList<Nodo> result) {
        this.searchResult = result;
        init();
    }

    public void plus() {
        int i = Integer.parseInt(number.getText());
        if (i >= searchResult.size() - 1) {
            next.setEnabled(false);
        }
        if (i == 1) {
            previus.setEnabled(true);
        }
        next.setText(Integer.toString(i + 1));
    }

    public void minus() {
        int i = Integer.parseInt(number.getText());
        if (i == 2) {
            previus.setEnabled(false);
        }
        if (i == searchResult.size()) {
            next.setEnabled(true);
        }
        next.setText(Integer.toString(i - 1));
    }

    private void setPages() {
        if (searchResult == null) {
            System.out.println("Lo que toca hacer cuando no encuentra nada");
            number.setText("0");
            next.setEnabled(false);
            showTree.setEnabled(false);
        } else if (searchResult.size() == 1) {
            number.setText("1");
            next.setEnabled(false);
            showInfo();
        } else if (searchResult.size() > 1) {
            number.setText("1");
            showInfo();
        }
    }

    private void showInfo() {
        int index;
        try {
            index = Integer.parseInt(number.getText());
        } catch (Exception e) {
            index = 0;
            System.out.println("ShowInfo error - number value incorrect");
        }
        Nodo n = searchResult.get(index-1);
        //info.setText(n.WriteInfo());
    }
}
