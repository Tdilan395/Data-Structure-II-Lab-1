/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;


/**
 * Esta clase contiene los atributos y metodos de un comentario
 * @author Dilan Triana 
 * @see Nodo
 */
public class Comment extends Nodo{
    private int postID;
    private String name;
    private String email;
    private String body;
    /**
     * Metodo constructor parametrizado
     * @param postID Id del post al que pertenece   
     * @param name   nombre de quien realizó el comentario
     * @param email correo electronico de quien realizó el comentario
     * @param body cuerpo del comentario
     * @param ID  Id del comentario
     */
    public Comment(int postID, String name, String email, String body, int ID) {
        super(ID);
        this.postID=postID;
        this.name = name;
        this.email = email;
        this.body = body;
    }
    /**
     * Metodo para obtener la Id del post al cual pertenece el comentario
     * @return entero que indica el post al que pertenece
     */
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
    

    /**
     * Metodo para verificar si el comentario hace parte de un determinado post
     * @param id id del post
     * @return booleano que indica si pertence o no.
     */
    boolean belongsTo(int id) {
        return this.postID == id;
    }
    /**
     * Metodo para transcribir los valores del objeto a un String
     */
    @Override
    public void printInfo(){
        System.out.println(postID + " - " + name +" - "+email+" - "+body);
    }
    }