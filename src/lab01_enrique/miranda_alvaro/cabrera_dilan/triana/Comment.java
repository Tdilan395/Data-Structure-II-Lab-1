package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 * Esta clase contiene los atributos y métodos de un comentario
 *
 * @author Dilan Triana
 * @see Nodo
 */
public class Comment extends Nodo {

    private final int postID;
    private final String name;
    private final String email;
    private final String body;

    /**
     * Método constructor parametrizado
     *
     * @param postID Id del post al que pertenece
     * @param name nombre de quien realizó el comentario
     * @param email correo electronico de quien realizó el comentario
     * @param body cuerpo del comentario
     * @param ID Id del comentario
     */
    public Comment(int postID, String name, String email, String body, int ID) {
        super(ID);
        this.postID = postID;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    /**
     * Método para obtener el ID del post al que pertenece.
     *
     * @return postID
     */
    public int getPostID() {
        return postID;
    }

    /**
     * Método para obtener el nombre de quien realizó el comentario
     *
     * @return nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Método para obtener la ruta simple. Esta información se utiliza en la
     * interfaz gráfica.
     *
     * @return String concatenada con el ID del comentario
     */
    @Override
    public String getSingleRoute() {
        return "Comment #" + this.getID();
    }

    /**
     * Método para obtener el email de quien realizó el comentario
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método para obtener el cuerpo(o contenido) del comentario.
     *
     * @return body
     */
    public String getBody() {
        return body;
    }

    /**
     * Método para verificar si el comentario pertenece a determinado Post
     *
     * @param id id del post que se desea evaluar
     * @return boolean cuyo valor variará según si pertenece o no.
     */
    boolean belongsTo(int id) {
        return this.postID == id;
    }

    /**
     * Método para añadir la información del comentario en una cadena de
     * caracteres
     *
     * @return String concatenado con la información del comentario
     */
    @Override
    public String printInfo() {
        String aux = body;
        aux = Reader.replace(aux,"\\n", " ");
        return ("ID: "+getID()+"\nPostID: " + postID + " \nName: " + name + " \nEmail: " + email + " \nBody: " + aux);
    }

    /**
     * Método que se utiliza en la interfaz gráfica para realizar la lista de
     * comentarios. En caso de estar seleccionado el comentario, se mostrará una
     * lista vacia con la indicación para volver.
     *
     * @return String con la información a mostrar
     */
    @Override
    public String toString() {
        if (etiquetaSelection) {
            return "← ← ← Back ← ← ← ";
        }
        return "💬 #" + this.getID() + ": " + this.name;
    }

}
