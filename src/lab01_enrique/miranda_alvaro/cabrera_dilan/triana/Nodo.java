package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase contiene todos los atributos y métodos de un Nodo
 *
 * @author Dilan Triana
 */
public class Nodo {

    private final int ID;
    private Nodo father;
    protected Boolean etiquetaSelection = false;
    private List ptr;

    /**
     * Método constructor parametrizado
     *
     * @param ID del nodo
     */
    public Nodo(int ID) {
        this.ID = ID;
        ptr = null;

    }

    /**
     * Método para obtener el Id del nodo.
     *
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Método para obtener la dirección de alguno de los hijos del nodo
     *
     * @param i el número del hijo que desea
     * @return Nodo i-esimo
     * @see List#getNodo()
     */
    public Nodo getLink(int i) {
        return (Nodo) ptr.getObjectbyIndex(i);
    }

    /**
     * Método para insertar Nodos
     *
     * @param nodo Nodo que se desea insertar
     * @param Raiz Raíz del árbol
     * @see List#add()
     */
    public void insertar(Nodo nodo, Nodo Raiz) {
        nodo.father = Raiz;
        ptr = List.add(Raiz.getLinks(), nodo);

    }

    /**
     * Método para realizar una busqueda en el segundo nivel del árbol. En este
     * caso se busca un post específico, según el parametro enviado.
     *
     * @param searchTo parametro del post que se desea encontrar: Id, name,
     * title, etc...
     * @param search valor del parametro que se desea buscar.
     * @see List#getObject()
     * @see List#addAll()
     * @return Retornar el nodo que cumpla con las especificaciones o nulo en
     * caso de no encontrarlo.
     */
    public List searchPost(String searchTo, String search) {
        List result = new List();
        List p = this.getLinks();
        while (p != null) {
            User u = (User) p.getObject();
            List post = u.search(searchTo, search);
            if (!post.isEmpty()) {
                result.addAll(post);
            }
            p = p.link;
        }
        if (result.link == null) {
            return new List();
        }
        return result.link;
    }

    /**
     * Método para obtener el primer nodo de la lista enlazada del nodo
     *
     * @return ptr o cabezal de la lista
     */
    public List getLinks() {
        return this.ptr;
    }

    /**
     * Método para realizar una busqueda en el tercer nivel del árbol. En este
     * caso se busca un comentario específico, según el parametro enviado.
     *
     * @param searchTo parametro del post que se desea encontrar: Id, postId,
     * body, etc...
     * @param search valor del parametro que se desea buscar.
     * @see List#getObject()
     * @see List#addAll()
     * @return Retornar el nodo que cumpla con las especificaciones o nulo en
     * caso de no encontrarlo.
     */
    public List searchComment(String searchTo, String search) {
        List result = new List();
        List p = this.getLinks();
        while (p != null) {
            User u = (User) p.getObject();
            List c = u.searchComment(searchTo, search);
            if (!c.isEmpty()) {
                result.addAll(c);
            }
            p = p.link;
        }
        if (result.link == null || result.link.link == null) {
            return new List();
        }
        return result.link.link;
    }

    /**
     * Método para imprimir toda la información de los hijos del nodo.
     * @see List#getObject()
     */
    public void printAllLinks() {
        List p = ptr;
        while (p.link != null) {
            Nodo aux = (Nodo) p.getObject();
            aux.printInfo();
            p = p.link;
        }
    }

    /**
     * Método para realizar una busqueda en el primer nivel del árbol. En este
     * caso se busca un usuario específico, según el parametro enviado.
     *
     * @param toSearch parametro del post que se desea encontrar: Id, postId,
     * body, etc...
     * @param search valor del parametro que se desea buscar.
     * @see List#getObject()
     * @see List#addAll()
     * @return Retornar el nodo que cumpla con las especificaciones o nulo en
     * caso de no encontrarlo.
     */
    public List search(String toSearch, String search) {//user
        Pattern pat = Pattern.compile(search);
        Matcher mat;
        List result = null;
        List p = this.getLinks();

        while (p != null) {
            User u = (User) p.getObject();
            switch (toSearch) {
                case "id":
                    if (String.valueOf(u.getID()).equals(search)) {
                        result = List.add(result, u);
                        if (result == null) {
                            return new List();
                        }
                        return result;
                    }
                    break;
                case "name":
                    mat = pat.matcher(u.getName());
                    if (mat.find()) {
                        result = List.add(result, u);
                    }
                    break;
                case "username":
                    if (u.getUsername().equals(search)) {
                        result =List.add(result, u);
                    }
                    break;
                case "email":
                    if (u.getEmail().equals(search)) {
                       result = List.add(result, u);
                    }
                    break;
                case "city":
                    if (u.getAddress().getCity().equals(search)) {
                       result = List.add(result, u);
                    }
                    break;
                case "phone":
                    if (u.getPhone().equals(search)) {
                       result = List.add(result, u);
                    }
                    break;
                case "website":
                    if (u.getWebsite().equals(search)) {
                       result = List.add(result, u);
                    }
                    break;
                case "comp-name":
                    if (u.getCompany().getName().equals(search)) {
                       result = List.add(result, u);
                    }
                    break;
                default:
                    System.out.println("Aquí no deberia llegar busqueda de usuarios desde nodo raiz");
                    break;
            }
            p = p.link;
        }
        if (result == null) {
            return new List();
        }
        return result;
    }

    /**
     * Método para imprimir la inforación de la ráiz.
     *
     * @return String vacío
     */
    public String printInfo() {
        return "";
    }

    /**
     * Método para obtener la ruta inicial del árbol. Se utiliza en la interfaz
     * gráfica.
     *
     * @return String vacío
     */
    public String getSingleRoute() {
        return "";
    }

    /**
     * Método para obtener el nodo padre.
     *
     * @return nodo father
     */
    public Nodo getFather() {
        return father;
    }

    /**
     * Método para escribir el objeto como una cadena de caracteres. Se utiliza
     * en la interfaz gráfica
     *
     * @return String con el valor, varía si el nodo está seleccionado o no.
     */
    @Override
    public String toString() {
        if (etiquetaSelection) {
            return "← ← ← Back ← ← ← ";
        }
        return "Users";
    }
}
