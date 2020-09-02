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

    public Post(int userID,String title, String body, int ID) {
        super(ID);
        this.title = title;
        this.body = body;
    }
    
    public int getUserID(){
        return this.userID;
    }
    
    @Override
    public Nodo buscar(int id,Nodo Raiz){
        for (Nodo user : Raiz.getLinks()) {
            for (Nodo post : user.getLinks()) {
                if(post.getID() == id) return post;
            }
        }
        return null;
    }
    
    @Override
    public void insertar(Nodo nodo, Nodo Raiz){
        Post p = (Post) nodo;
        Nodo user = Raiz.buscar(p.getUserID(),Raiz);
        if(user == null){
            System.out.println("Hola, no funciona, perdón");
            //mostrar mensaje de error
        }
        else{
            user.insertar(nodo, user);
        }
        
    }
    
    public boolean isOwner(int i){
        return this.userID == i;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
    
    @Override
    public void printInfo(){
        System.out.println(userID + "   " + title + "   " + body);
        System.out.println("");
        this.printAllLinks();
    }
}
