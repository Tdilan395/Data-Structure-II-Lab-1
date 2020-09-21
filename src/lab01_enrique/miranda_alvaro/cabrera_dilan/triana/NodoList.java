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

    private Object nodo;
    NodoList link;

    public static NodoList add(NodoList ptr, Object nodo) {
        NodoList p = ptr;
        NodoList q = new NodoList();
        q.nodo = nodo;
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

    public Object getNodo( int pos) {
        NodoList p = this;
        int i = 0;
        while (p.link != null && i != pos) {
            i++;
            p = p.link;
        }
        if (i == pos) {
            return p.getObject();
        } else {
            return null;
        }

    }

    public Object getObject() {
        return nodo;
    }

    public int size() {
        int i = 0;
        NodoList p = this;
        while (p != null) {
            p = p.link;
            i++;
        }
        return i;
    }

    public boolean isEmpty() {
        return link==null&&nodo==null;
    }

    void addAll(NodoList c) {
        NodoList p = this;
        while (p.link != null) {
            p = p.link;
        }
        p.link = c;
    }

}
