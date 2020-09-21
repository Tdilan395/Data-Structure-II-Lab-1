/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 * Esta clase contiene todos los metodos y parametros del Arbol 
 * @author Enrique Miranda
 */
public class AB {
    public Nodo raiz;
    
    public AB(){
        raiz = new Nodo(0);
    }
    /**
     * Añade los nodos a que serán sus hijos.
     * @param nodo El nodo que se desea añadir
     */
    public void insertar(Nodo nodo){
        raiz.insertar(nodo,raiz);
    }
    /**
     * Metodo para imprimir la información de todos los nodos del arbol
     */
    public void print(){
        raiz.printAllLinks();
    }
    
}
