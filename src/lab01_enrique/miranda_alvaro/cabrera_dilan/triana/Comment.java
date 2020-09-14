/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;


/**
 *
 * @author Domain
 */
public class Comment extends Nodo{
    private int postID;
    private String name;
    private String email;
    private String body;

    public Comment(int postID, String name, String email, String body, int ID) {
        super(ID);
        this.postID=postID;
        this.name = name;
        this.email = email;
        this.body = body;
    }
    
    public int getPostID(){
        return postID;
    }
    
    @Override
    public Nodo buscar(int id, Nodo Raiz){
        for (Nodo user : Raiz.getLinks()) {
            for (Nodo post : user.getLinks()) {
                for (Nodo comment : post.getLinks()) {
                    if(comment.getID() == id) return comment;
                }
            }
        }
        return null;
    }
    


    boolean belongsTo(int id) {
        return this.postID == id;
    }
    
    @Override
    public String printInfo(){
//        System.out.println(postID + " - " + name +" - "+email+" - "+body);
        return (postID + " \n- " + name +" \n- "+email+" \n- "+body);
    }
    @Override
    public String toString() {
        return "Comment #" + this.getID() + ": " + this.name;
    }
}
