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

    public Comment(String name, String email, String body, int ID) {
        super(ID);
        this.name = name;
        this.email = email;
        this.body = body;
    }
    
    @Override
    public Nodo buscar(int id, Nodo Raiz){
        for (Nodo link : Raiz.links()) {
            for (Nodo link1 : link.links()) {
                for (Nodo link2 : link1.links()) {
                    if(link2.getID() == id) return link2;
                }
            }
        }
        return null;
    }
    
    @Override
    public void insertar(Nodo nodo, Nodo Raiz){
       
    }

    boolean belongsTo(int id) {
        return this.postID == id;
    }
    
    }