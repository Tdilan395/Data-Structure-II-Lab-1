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
public class Post extends Nodo{
    private int userID;
    private String title;
    private String body;

    public Post(String title, String body, int ID) {
        super(ID);
        this.title = title;
        this.body = body;
    }
    
    public int getUserID(){
        return this.userID;
    }
    
    @Override
    public Nodo buscar(int id,Nodo Raiz){
        for (Nodo link : Raiz.links()) {
            for (Nodo link1 : link.links()) {
                if(link1.getID() == id) return link1;
            }
        }
        return null;
    }
    
    @Override
    public void insertar(Nodo nodo, Nodo Raiz){
        Post p = (Post) nodo;
        Nodo user = buscar(p.getUserID(),Raiz);
        user.insertar(nodo, user);
    }
    
    public boolean isOwner(int i){
        return this.userID == i;
    }
}
