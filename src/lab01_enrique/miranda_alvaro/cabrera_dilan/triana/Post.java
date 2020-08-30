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
public class Post extends Nodo{
    private String title;
    private String body;

    public Post(String title, String body, int ID, Nodo frere, Nodo son) {
        super(ID, frere, son);
        this.title = title;
        this.body = body;
    }
    
    
}
