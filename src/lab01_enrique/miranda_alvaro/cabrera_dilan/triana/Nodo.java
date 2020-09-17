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
public class Nodo {
    private final int ID;
    private NodoList ptr;

    public Nodo(int ID) {
        this.ID = ID;
        ptr=null;
   
    }
    
    public int getID() {
        return ID;
    }
    public Nodo getLink(int i){
        return (Nodo)NodoList.getNodo(ptr, i);
    }
    
    /**
     *
     * @param nodo
     * @param Raiz
     * @since 0.2
     */
    public void insertar(Nodo nodo, Nodo Raiz) {
        ptr= NodoList.add(Raiz.getLinks(),nodo);
    }
    
    /**
     *
     * @param id
     * @param Raiz
     * @since 0.2
     * @return
     */
    public Nodo buscar(int id, Nodo Raiz){
        NodoList p = ptr;
        while(p!=null){
            Nodo aux=(Nodo)p.getNodo();
            if(aux.getID()==id) return aux;
            else p=p.link;
        }
        return null;
    }
    
    public NodoList getLinks(){
        return this.ptr;
    }
    
    public void printAllLinks(){
        NodoList p = ptr;
        while(p.link!=null){
            Nodo aux=(Nodo)p.getNodo();
             aux.printInfo();
             p=p.link;
        }
    }

    public String printInfo() {
        return "";
    }
    @Override
    public String toString(){
        return "Users";
    }
}
