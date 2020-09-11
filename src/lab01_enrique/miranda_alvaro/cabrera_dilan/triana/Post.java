/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 * Esta clase contiene todos los parametros y metodos de un Post
 *
 * @author Dilan Triana
 */
public class Post extends Nodo {

    private int userID;
    private String title;
    private String body;

    /**
     * Metodo constructo parametrizado
     *
     * @param userID Id del usario que realizó el post
     * @param title titulo del post
     * @param body contenido del post
     * @param ID id del post
     */
    public Post(int userID, String title, String body, int ID) {
        super(ID);
        this.title = title;
        this.body = body;
        this.userID = userID;
    }
    /**
     * Metodo para obtener el ID del usuario que realizó el post
     * @return el Id del usuario
     */
    public int getUserID() {
        return this.userID;
    }

    @Override
    public Nodo buscar(int id, Nodo Raiz) {
        for (Nodo user : Raiz.getLinks()) {
            for (Nodo post : user.getLinks()) {
                if (post.getID() == id) {
                    return post;
                }
            }
        }
        return null;
    }
    /**
     * Metodo para verificar si el ID introducido corresponde con el usuario que realizó el post
     * @param i id del usuario
     * @return boolean que indica si pertenece o no
     */
    public boolean isOwner(int i) {
        return this.userID == i;
    }
    /**
     * Metodo para obtener el tiulo del post
     * @return  titulo
     */
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
    /**
     * Metodo para imprimir toda la información del objeto en una cadena de caracteres
     */
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
}
