/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import javax.swing.JOptionPane;

/**
 *
 * @author Domain
 */
public class Comment extends Nodo{
    private int postID;
    private String name;
    private String email;
    private String body;

    public Comment(String name, String email, String body, int ID, Nodo frere, Nodo son) {
        super(ID, frere, son);
        this.name = name;
        this.email = email;
        this.body = body;
    }

    boolean belongsTo(int id) {
        return this.postID == id;
    }
    
    }