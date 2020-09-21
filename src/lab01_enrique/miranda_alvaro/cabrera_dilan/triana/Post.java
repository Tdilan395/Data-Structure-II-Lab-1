/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase contiene todos los parametros y metodos de un Post
 *
 * @author Dilan Triana
 */
public class Post extends Nodo {

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

    public int getUserID() {
        return this.userID;
    }
    

    public String getTitle() {
        return title;
    }
    /**
     * Metodo para obtener el cuerpo del post
     * @return cuerpo
     */
    public String getBody() {
        return body;
    }

    @Override
    public String getSingleRoute(){
        return "Post #" + this.getID();
    }
    
    @Override
    public String printInfo(){
//        System.out.println("");
//        System.out.println("**********************************POST********************************************");
//        System.out.println(userID + "   " + title + "   " + body);
//        System.out.println("");
//        System.out.println("");
//        System.out.println("**********************************COMENTARIOS********************************************");
//        this.printAllLinks();
    String aux=body;
        aux=aux.replace("\\n", "");
        System.out.println(title.length());
        return ("UserID: "+userID + "\n"+"Title: " + title + "\n" +"Body: " +aux);
    }

    @Override
    public String toString() {
        if (etiquetaSelection) {
            return "← ← ← Back ← ← ← ";
        }
        return "📄 #" + this.getID() + ": " + this.getTitle();
    }

    @Override
    public NodoList search(String searchTo, String search) {//comment
        Pattern pat = Pattern.compile(search);
        Matcher mat;
        NodoList result = null;
        NodoList p = this.getLinks();
        while(p!=null) {
            Comment c = (Comment) p.getObject();
            switch (searchTo) {
                case "postId":
                    if (String.valueOf(c.getPostID()).equals(search)) {
                        result = NodoList.add(result, c);
                    }
                    break;
                case "id":
                    if (String.valueOf(c.getID()).equals(search)) {
                        result = NodoList.add(result, c);
                        if(result==null)return new NodoList();
                        return result;
                    }
                    break;
                case "name":
                    if (c.getName().equals(search)) {
                        result = NodoList.add(result, c);
                    }
                    break;
                case "email":
                    if (c.getEmail().equals(search)) {
                        result = NodoList.add(result, c);
                    }
                    break;
                case "body":
                    mat = pat.matcher(c.getBody());
                    if (mat.find()) {
                        result = NodoList.add(result, c);
                    }
                    break;
                default:
                    System.out.println("No deberia estár aquí busqueda de comment");
                    break;
            }
            p=p.link;
        }
        if(result==null)return new NodoList();
        return result;
    }
    
//    @Override
//    public String WriteInfo() {
//        StringBuffer b = new StringBuffer();
//        
//        b.append("Post info");
//        
//        return b.toString();
//    }
}
