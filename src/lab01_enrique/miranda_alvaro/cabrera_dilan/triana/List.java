
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 * Esta clase contiene todos los atributos y métodos de una lista enlazada
 * simple.
 *
 * @author Alvaro Cabrera
 */
public class List {

    private Object object;
    List link;

    /**
     * Método para agregar un nodo a la lista.
     *
     * @param ptr cabezal de la lista
     * @param object object que se desea añadir
     * @return ptr
     */
    public static List add(List ptr, Object object) {
        List p = ptr;
        List q = new List();
        q.object = object;
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

    /**
     * Método para obtener un nodo dentro de una lista enlazada según su
     * posición.
     *
     * @param pos posición del nodo dentro de la lista
     * @see #getObject() 
     * @return Nodo encontrado o nulo en caso de no hallarse la posición.
     */
    public Object getObjectbyIndex(int pos) {
        List p = this;
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
    /**
     * Método para obtener el contenido del método. 
     * 
     * @return object que contiene el nodo
     */
    public Object getObject() {
        return object;
    }
    /**
     * Método para obtener el tamaño de una lista enlazada simple.
     * @return Int que indica el tamaño de la lista
     */
    public int size() {
        int i = 0;
        List p = this;
        while (p != null) {
            p = p.link;
            i++;
        }
        return i;
    }
    /**Método para determinar si una lista está vacía
     * 
     * @return  booleano que indica si la lista está vacía
     */
    public boolean isEmpty() {
        return link == null && object == null;
    }
    /**
     * Método para unir dos listas.
     * @param c  cabezal de la lista que se desea unir. 
     */
    void addAll(List c) {
        List p = this;
        while (p.link != null) {
            p = p.link;
        }
        p.link = c;
    }

}
