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
    NodoList ptr2;
    
    public Post(int userID,String title, String body, int ID) {
        super(ID);
        this.title = title;
        this.body = body;
        this.userID = userID;
        ptr2=null;
    }
    
    public int getUserID(){
        return this.userID;
    }
    
//    @Override
//    public Nodo buscar(int id,Nodo Raiz){
//        for (Nodo user : Raiz.getLinks()) {
//            for (Nodo post : user.getLinks()) {
//                if(post.getID() == id) return post;
//            }
//        }
//        return null;
//    }
    

    
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
    public String printInfo(){
//        System.out.println("");
//        System.out.println("**********************************POST********************************************");
//        System.out.println(userID + "   " + title + "   " + body);
//        System.out.println("");
//        System.out.println("");
//        System.out.println("**********************************COMENTARIOS********************************************");
//        
//        this.printAllLinks();
    String aux=body;
        aux=aux.replace("\\n", "");
        System.out.println(title.length());
        return ("UserID: "+userID + "\n"+"Title: " + title + "\n" +"Body: " +aux);
    }
    
    @Override
    public String toString(){
        return "Post #" + this.getID() + ": " + this.getTitle();
    }
}
