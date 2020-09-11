/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.ArrayList;

/**
 * Esta clase contiene todos los atributos y metodos de un Nodo
 * @author Domain
 */
public class Nodo {
    private final int ID;
    private ArrayList<Nodo> links;
    /**
     * Metodo constructor parametrizado
     * @param ID  id del nodo
     */
    public Nodo(int ID) {
        this.ID = ID;
        links = new ArrayList<>();
    }
    /**
     * Metodo para obtener el id del nodo
     * @return Id del nodo
     */
    public int getID() {
        return ID;
    }
    /**
     * Metodo para obtener la dirección de alguno de los hijos del nodo
     * @param i el número del hijo que desea
     * @return Nodo i-esimo
     */
    public Nodo getLink(int i){
        return links.get(i);
    }
    
    /**
     * Metodo para insertar Nodos
     * @param nodo nodo que se desea insertar
     * @param Raiz Raiz del arbol
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
    /**
     * Metodo para obtener la lista de hijos del nodo
     * @return Hijos del nodo
     */
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
    
}
