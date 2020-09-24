package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase contiene todo lo concerniente a la lectura de un archivo con
 * formato JSON y a la transformación hacia objetos de la clase
 *
 * @author Alvaro Cabrera
 * @see Yeison
 * @see User
 * @see Comment
 * @see Post
 */
public class Reader {

    /**
     * Método que lee un archivo que contiene formato JSON, y cuyos tamaño de
     * los objetos está establecido
     *
     * @param lim1 línea en que comienza el objeto JSON
     * @param lim2 línea en que termina el objeto JSON
     * @param ruta nombre del archivo a ser leído
     * @see List#add(lab01_enrique.miranda_alvaro.cabrera_dilan.triana.List,
     * java.lang.Object)
     * @see Yeison
     * @return un cabezal de tipo List, que representa la lista de objetos JSON
     */
    public static List deArchivoALista(int lim1, int lim2, String ruta) {
        List objetos = null;
        File f = new File("files/" + ruta + ".txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int cont = 0;
            String linea;
            String object = "";
            while ((linea = br.readLine()) != null) {
                if (cont >= lim1 && cont <= lim2) {
                    object += linea + "\n";
                }
                cont++;
                if (cont == lim2) {
                    object += "},";
                    Yeison y = new Yeison(object);
                    objetos = List.add(objetos, y);
                    object = "";
                    cont = 0;
                }
            }
            return objetos;

        } catch (FileNotFoundException ex) {
            System.out.println("sí pasé FILO NOT");

            return objetos;
        } catch (IOException ex) {
            System.out.println("sí pasé IOEX");

            return objetos;
        }
    }

    /**
     * Método para crear objetos tipo User a partir de un objeto Yeison
     *
     * @param ob Objeto Yeison que contiene la información del User
     * @see Address
     * @see Company
     * @see User
     * @return regresa el objeto tipo User
     */
    public static User deYeisonaUser(Yeison ob) {
        Yeison address = new Yeison(ob.get("address"));
        Yeison company = new Yeison(ob.get("company"));
        Yeison geo = new Yeison(address.get("geo"));
        float ge[] = {Float.parseFloat(geo.get("lat")), Float.parseFloat(geo.get("lng"))};
        Address a = new Address(address.get("street"), address.get("suite"), address.get("city"), address.get("zipcode"), ge);
        Company c = new Company(company.get("name"), company.get("catchPhrase"), company.get("bs"));
        return new User(Integer.parseInt(ob.get("id")), ob.get("name"), ob.get("username"), ob.get("email"), ob.get("phone"), ob.get("website"), c, a);
    }

    /**
     * Método para crear objetos tipo Post a partir de un objeto Yeison
     *
     * @param ob Objeto Yeison que contiene la información del Post
     * @see Post
     * @return regresa el objeto tipo Post
     */
    public static Post deYeisonaPost(Yeison ob) {
        return new Post(Integer.parseInt(ob.get("userId")), ob.get("title"), ob.get("body"), Integer.parseInt(ob.get("id")));
    }

    /**
     * Método para crear objetos tipo Comment a partir de un objeto Yeison
     *
     * @param ob Objeto Yeison que contiene la información del Comment
     * @see Comment
     * @return regresa el objeto tipo Comment
     */
    public static Comment deYeisonaComment(Yeison ob) {
        return new Comment(Integer.parseInt(ob.get("postId")), ob.get("name"), ob.get("email"), ob.get("body"), Integer.parseInt(ob.get("id")));
    }

    /**
     * Método para añadir los objetos tipo User, Post y Comment al arbol
     *
     * @param nivel Indica en que nivel deseamos agregar el objeto 1=User, 2=
     * Post, 3=Comment
     * @see Nodo
     * @see User
     * @see List
     * @see Post
     * @see Comment
     * @see
     * #deYeisonaComment(lab01_enrique.miranda_alvaro.cabrera_dilan.triana.Yeison)
     * @see
     * #deYeisonaPost(lab01_enrique.miranda_alvaro.cabrera_dilan.triana.Yeison)
     * @see
     * #deYeisonaUser(lab01_enrique.miranda_alvaro.cabrera_dilan.triana.Yeison)
     * @see #deArchivoALista(int, int, java.lang.String)
     * @param raiz La raiz del arbol donde deseamos agregar
     */
    public static void Agregar(int nivel, Nodo raiz) {
        switch (nivel) {
            case 1:
                List usuarios = Reader.deArchivoALista(1, 23, "usuario");
                User a;
                while (usuarios != null) {
                    a = deYeisonaUser((Yeison) usuarios.getObject());
                    raiz.insertar(a, raiz);
                    Agregar(2, a);
                    usuarios = usuarios.link;
                }
                break;
            case 2:
                List posts = Reader.deArchivoALista(1, 6, "posts");
                Post p;

                while (posts != null) {
                    p = deYeisonaPost((Yeison) posts.getObject());

                    if (p.getUserID() == raiz.getID()) {
                        raiz.insertar(p, raiz);
                        Agregar(3, p);

                    }
                    if (p.getLinks() != null && p.getUserID() != raiz.getID()) {
                        break;
                    }
                    posts = posts.link;
//
                }
                break;
            case 3:
                List comentarios = Reader.deArchivoALista(1, 7, "comments");
                Comment c;

                while (comentarios != null) {
                    c = deYeisonaComment((Yeison) comentarios.getObject());

                    if (c.getPostID() == raiz.getID()) {
                        raiz.insertar(c, raiz);

                    }
                    comentarios = comentarios.link;
                }
                break;
            default:
                System.out.println("Solo existen 3 niveles. ");
        }
    }

    /**
     * Método que se encarga de buscar diferentes caracteres o subcadenas
     * dentrode un cadena de caracateres y reemplaza los resultados con un valor
     * deseado
     *
     * @param cadena cadena de caracteres que se debe evaluar
     * @param toReplace valor que deseamos reemplazar
     * @param replaceTo valor con que se desea reemplazar
     * @return La cadena de caracteres editada
     */
    public static String replace(String cadena, String toReplace, String replaceTo) {
        String result = cadena;
        if (toReplace.length() > cadena.length()) {
            return cadena;
        }
        for (int i = 0; i <= result.length() - toReplace.length(); i++) {
            if (result.substring(i, i + toReplace.length()).equals(toReplace)) {
                return result.substring(0, i) + replaceTo + replace(result.substring(i + toReplace.length()), toReplace, replaceTo);
            }
        }
        return cadena;
    }
}
