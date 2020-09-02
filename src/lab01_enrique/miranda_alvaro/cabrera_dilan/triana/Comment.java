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
    
    @Override
    public void insertar(Nodo nodo, Nodo Raiz){
        Comment c = (Comment) nodo;
        Post p = new Post(0,"","",0);
        p = (Post)p.buscar(c.getPostID(), Raiz);
        if(p == null){
            //mostrar mensaje de error
        }else{
            Raiz.insertar(nodo, p);
        }
    }

    boolean belongsTo(int id) {
        return this.postID == id;
    }
    
    public void printInfo(){
        System.out.println("");
        System.out.println(postID + " - " + name +" - "+email+" - "+body);
    }
    }