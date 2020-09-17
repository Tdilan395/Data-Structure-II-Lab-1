/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 *
 * @author Enrique
 */
public class AB {
    public Nodo raiz;
    
    public AB(){
        raiz = new Nodo(0);
    }
    
    public void insertar(Nodo nodo){
        raiz.insertar(nodo,raiz);
    }
    
    public void print(){
        raiz.printAllLinks();
    }
    
}
