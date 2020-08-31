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
public class User extends Nodo{
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company;
    private Address address;

    public User(int ID, Nodo frere, Nodo son) {
        super(ID, frere, son);
    }
    
    @Override
    public void insertar(Nodo nodo, Nodo Raiz) {
        if (Raiz == null) {
            Raiz = nodo;
        } else {
            if (nodo instanceof User) {
                if (Raiz.frere == null) {
                    Raiz.frere = nodo;
                } else {
                    insertar(nodo, Raiz.frere);
                }
            } else if (nodo instanceof Post) {
                User u = (User) Raiz;
                Post p = (Post) nodo;
                if (p.isOwner(u.getID())) {
                    if (Raiz.son == null) {
                        Raiz.son = nodo;
                    } else {
                        Raiz.son.insertar(nodo, Raiz.son);
                    }
                } else {
                    insertar(nodo, Raiz.frere);
                }
            } else {
                //para dilan
            }
        }
    }
}
