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
public class Comment extends Nodo {

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
        this.postID = postID;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostID() {
        return postID;
    }

    public String getName() {
        return name;
    }
    
    
    @Override
    public String getSingleRoute(){
        return "Comment #" + this.getID();
    }
        
    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    boolean belongsTo(int id) {
        return this.postID == id;
    }
    /**
     * Metodo para transcribir los valores del objeto a un String
     */
    @Override
    public String printInfo(){
        String aux=body;
        aux=aux.replace("\\n", "");
        return ("PostID: "+postID + " \nName: " + name +" \nEmail: "+email+" \nBody: "+aux);
    }

    @Override
    public String toString() {
        if(etiquetaSelection)return "← ← ← Back ← ← ← ";
        return "💬 #" + this.getID() + ": " + this.name;
    }

    @Override
    public NodoList search(String searchTo, String search) {
        System.out.println("Nunca debería estar aquí");
        return new NodoList();
    }
    
//    @Override
//    public String WriteInfo() {
//        StringBuffer b = new StringBuffer();
//        
//        b.append("Comment info");
//        
//        return b.toString();
//    }
}
