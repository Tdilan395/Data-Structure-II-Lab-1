package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 * Esta clase contiene todos los métodos y parametros del Árbol
 *
 * @author Enrique Miranda
 */
public class AB {

    public Nodo raiz;

    /**
     * Método constructor en el que se crea la raíz vacia del árbol
     */
    public AB() {
        raiz = new Nodo(0);
    }

    /**
     * Añade los nodos que serán sus hijos.
     *
     * @param nodo El nodo que se desea añadir
     */
    public void insertar(Nodo nodo) {
        raiz.insertar(nodo, raiz);
    }

    /**
     * Método para imprimir la información de todos los nodos del árbol
     */
    public void print() {
        raiz.printAllLinks();
    }

}
