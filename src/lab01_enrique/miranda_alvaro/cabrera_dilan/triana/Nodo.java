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
public abstract class Nodo {
    private final int ID;
    Nodo frere;
    Nodo son;

    public Nodo(int ID, Nodo frere, Nodo son) {
        this.ID = ID;
        this.frere = frere;
        this.son = son;
    }
    
    public void insertar(Nodo nodo, Nodo Raiz){ }

    public int getID() {
        return ID;
    }

    public Nodo getFrere() {
        return frere;
    }

    public Nodo getSon() {
        return son;
    }
    
    
}
