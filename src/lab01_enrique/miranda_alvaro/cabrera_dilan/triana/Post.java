package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase contiene todos los parametros y métodos de un Post
 *
 * @author Dilan Triana
 */
public class Post extends Nodo {

    private final int userID;
    private final String title;
    private final String body;
    List ptr2;

    /**
     * Método constructor parametrizado.
     *
     * @param userID Id del usuario que realizó el post
     * @param title título del post
     * @param body cuerpo del post
     * @param ID id del post
     */
    public Post(int userID, String title, String body, int ID) {
        super(ID);
        this.title = title;
        this.body = body.replace("\\n", " ");
        this.userID = userID;
        ptr2 = null;
    }

    /**
     * Método para obtener el Id del usuario al que pertenece
     *
     * @return userID
     */
    public int getUserID() {
        return this.userID;
    }

    /**
     * Método para obtener el titulo del post
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Método para obtener el cuerpo del post
     *
     * @return cuerpo
     */
    public String getBody() {
        return body;
    }

    /**
     * Método para obtener la ruta simple. Esta información se utiliza en la
     * interfaz gráfica.
     *
     * @return String concatenada con el ID del post
     */
    @Override
    public String getSingleRoute() {
        return "Post #" + this.getID();
    }

    /**
     * Método para añadir la información del post en una cadena de caracteres
     *
     * @return String concatenado con la información del post
     */
    @Override
    public String printInfo() {
        String aux = body;
        aux = Reader.replace(aux,"\\n", " ");
        return ("ID: "+getID()+"\nUserID: " + userID + "\n" + "Title: " + title + "\n" + "Body: " + aux);
    }

    /**
     * Método que se utiliza en la interfaz gráfica para realizar la lista de
     * post. En caso de estar seleccionado el post, se mostrará una lista vacia
     * con la indicación para volver.
     *
     * @return String con la información a mostrar
     */
    @Override
    public String toString() {
        if (etiquetaSelection) {
            return "← ← ← Back ← ← ← ";
        }
        return "📄 #" + this.getID() + ": " + this.getTitle();
    }

    /**
     * Método para realizar una busqueda en el tercer nivel del árbol. En este
     * caso se busca un comentario específico, según el parametro enviado.
     *
     * @param searchTo parametro del comentario que se desea encontrar: Id,
     * body, email, etc...
     * @param search valor del parametro que se desea buscar.
     * @see List#getObject()
     * @see List#addAll()
     * @return Retornar el nodo que cumpla con las especificaciones o nulo en
     * caso de no encontrarlo.
     */
    @Override
    public List search(String searchTo, String search) {//comment
        Pattern pat = Pattern.compile(search);
        Matcher mat;
        List result = null;
        List p = this.getLinks();
        while (p != null) {
            Comment c = (Comment) p.getObject();
            switch (searchTo) {
                case "postId":
                    if (String.valueOf(c.getPostID()).equals(search)) {
                        result = List.add(result, c);
                    }
                    break;
                case "id":
                    if (String.valueOf(c.getID()).equals(search)) {
                        result = List.add(result, c);
                        if (result == null) {
                            return new List();
                        }
                        return result;
                    }
                    break;
                case "name":
                    mat = pat.matcher(c.getName());
                    if (mat.find()) {
                        result = List.add(result, c);
                    }
                    break;
                case "email":
                    if (c.getEmail().equals(search)) {
                        result = List.add(result, c);
                    }
                    break;
                case "body":
                    mat = pat.matcher(Reader.replace(c.getBody(),"\\n", " "));
                    if (mat.find()) {
                        result = List.add(result, c);
                    }
                    break;
                default:
                    System.out.println("No deberia estár aquí busqueda de comment");
                    break;
            }
            p = p.link;
        }
        if (result == null) {
            return new List();
        }
        return result;
    }
}
