/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Domain
 */
public class Post extends Nodo {

    private int userID;
    private String title;
    private String body;

    public Post(int userID, String title, String body, int ID) {
        super(ID);
        this.title = title;
        this.body = body;
        this.userID = userID;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public void printInfo() {
        System.out.println("");
        System.out.println("**********************************POST********************************************");
        System.out.println(userID + "   " + title + "   " + body);
        System.out.println("");
        System.out.println("");
        System.out.println("**********************************COMENTARIOS********************************************");

        this.printAllLinks();
    }

    @Override
    public String toString() {
        return "Post #" + this.getID() + ": " + this.getTitle();
    }

    @Override
    public Nodo search(String searchTo, String search) {//comment
        Pattern pat = Pattern.compile(search);
        Matcher mat;
        System.out.println("**************Busqueda de comentario**************");
        for (Nodo comment : getLinks()) {
            Comment c = (Comment) comment;
            switch (searchTo) {
                case "postId":
                    if (c.getPostID() == Integer.parseInt(search)) {
                        return c;
                    }
                    break;
                case "id":
                    if (c.getID() == Integer.parseInt(search)) {
                        return c;
                    }
                    break;
                case "name":
                    if (c.getName().equals(search)) {
                        return c;
                    }
                    break;
                case "email":
                    if (c.getEmail().equals(search)) {
                        break;
                    }
                case "body":
                    mat = pat.matcher(c.getBody());
                    if (mat.find()) {
                        return c;
                    }
                    break;
                default:
                    System.out.println("No deberia estár aquí busqueda de comment");
                    break;
            }
        }
        return null;
    }
}
