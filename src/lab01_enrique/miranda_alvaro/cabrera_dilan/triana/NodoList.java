/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 *
 * @author Alvaro Cabrera
 */
public class NodoList {
        private Nodo nodo;
        private NodoList link;
    
    public static NodoList addCola(NodoList ptr, Nodo nodo) {
        NodoList p = ptr;
        NodoList q = new NodoList();
        q.nodo=nodo;
        if (ptr == null) {
            ptr = q;
        } else {
            while (p.link != null) {
                p = p.link;
            }
            p.link = q;
        }
        return ptr;
    }
    public Nodo getNodo(NodoList ptr, int pos){
    NodoList p=ptr;
    int i=0;
        if(ptr==null){
        return null;
        }else{
        while(p.link!=null && i!=pos){
           p= p.link;
        }
            if(i==pos){
            return p.getNodo();
            }else{
            return null;
            }
        }
    }
    public Nodo getNodo() {
        return nodo;
    }
    
}
