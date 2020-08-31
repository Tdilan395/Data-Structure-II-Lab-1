/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import javax.swing.JOptionPane;

/**
 *
 * @author Domain
 */
public class Post extends Nodo{
    private int userID;
    private String title;
    private String body;

    public Post(String title, String body, int ID, Nodo frere, Nodo son) {
        super(ID, frere, son);
        this.title = title;
        this.body = body;
    }
    
    @Override
    public void insertar(Nodo nodo, Nodo Raiz) {
        if (Raiz == null) {
            JOptionPane.showMessageDialog(null, "TE JODISTE");
        } else {
            if (nodo instanceof Post) {
                if(Raiz.frere == null){
                    Raiz.frere = nodo;
                }else{
                    insertar(nodo,Raiz.frere);
                }
            } else if (nodo instanceof Comment) {
                Comment c = (Comment) nodo;
                Post p = (Post) Raiz;
                if (c.belongsTo(p.getID())) {
                    if (Raiz.son == null) {
                        Raiz.son = nodo;
                    } else {
                        Raiz.son.insertar(nodo, Raiz.son);
                    }
                } else {
                    insertar(nodo, Raiz.frere);
                }
            } else {
                JOptionPane.showMessageDialog(null, "TE JODISTE");
            }
        }
    }
    public boolean isOwner(int i){
        return this.userID == i;
    }
}
