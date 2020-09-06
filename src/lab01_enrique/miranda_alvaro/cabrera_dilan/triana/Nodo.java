/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.ArrayList;

/**
 *
 * @author Domain
 */
public class Nodo {
    private final int ID;
    private ArrayList<Nodo> links;

    public Nodo(int ID) {
        this.ID = ID;
        links = new ArrayList<>();
    }
    
    public int getID() {
        return ID;
    }
    public Nodo getLink(int i){
        return links.get(i);
    }
    
    /**
     *
     * @param nodo
     * @param Raiz
     * @since 0.2
     */
    public void insertar(Nodo nodo, Nodo Raiz) {
        Raiz.getLinks().add(nodo);
    }
    
    /**
     *
     * @param id
     * @param Raiz
     * @since 0.2
     * @return
     */
    public Nodo buscar(int id, Nodo Raiz){
        for (Nodo link : Raiz.links) {
            if (link.getID() == id) return link;
        }
        return null;
    }
    
    public ArrayList<Nodo> getLinks(){
        return this.links;
    }
    
    public void printAllLinks(){
        for (Nodo link : links) {
            link.printInfo();
        }
    }

    public void printInfo() {
        
    }
    @Override
    public String toString(){
        return "Users";
    }
}
