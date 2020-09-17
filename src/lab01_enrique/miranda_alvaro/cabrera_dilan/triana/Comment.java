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
public class Comment extends Nodo {

    private int postID;
    private String name;
    private String email;
    private String body;

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

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String printInfo(){
//        System.out.println(postID + " - " + name +" - "+email+" - "+body);
        return (postID + " \n- " + name +" \n- "+email+" \n- "+body);
    }

    @Override
    public String toString() {
        if(etiquetaSelection)return "...";
        return "Comment #" + this.getID() + ": " + this.name;
    }

    @Override
    public Nodo search(String searchTo, String search) {
        System.out.println("Nunca debería estar aquí");
        return null;
    }
    
    @Override
    public String WriteInfo() {
        StringBuffer b = new StringBuffer();
        
        b.append("Comment info");
        
        return b.toString();
    }
}
