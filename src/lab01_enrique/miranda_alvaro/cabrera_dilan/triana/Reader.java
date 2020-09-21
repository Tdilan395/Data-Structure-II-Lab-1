/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *  Esta clase contiene todo lo concerniente a la lectura de un archivo con formato JSON y a la transformación hacia objetos de la clase
 * @author Alvaro Cabrera
 * @see Yeison
 * @see User
 * @see Comment
 * @see Post
 */
public class Reader {

    public static NodoList deArchivoALista(int lim1, int lim2, String ruta) {
        NodoList objetos=null;
        File f = new File(ruta + ".txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int cont = 0;
            String linea;
            String object = "";
            while ((linea = br.readLine()) != null) {
                if (cont >= lim1 && cont <= lim2) {
                    object +=linea+"\n";
                }
                cont++;
                if (cont == lim2) {
                   object+= "},"; 
                    Yeison y = new Yeison(object);
                    objetos=NodoList.add(objetos, y);
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
     * Metodo para crear objetos tipo User a partir de un objeto Yeison
     * @param ob Objeto Yeison que contiene la información del User
     * @return regresa el objeto tipo User
     */
    public static User deYeisonaUser(Yeison ob) {
        Yeison address = new Yeison(ob.get("address"));
        Yeison company = new Yeison(ob.get("company"));
      Yeison geo = new Yeison(address.get("geo"));
        float ge[] = {Float.parseFloat(geo.get("lat")), Float.parseFloat(geo.get("lng"))};
       Address a = new Address(address.get("street"), address.get("suite"), address.get("city"), address.get("zipcode"), ge);
       Company c = new Company(company.get("name"), company.get("catchPhrase"), company.get("bs"));
          return  new User(Integer.parseInt(ob.get("id")), ob.get("name"), ob.get("username"), ob.get("email"), ob.get("phone"), ob.get("website"), c, a);
    }
    /**
     * Metodo para crear objetos tipo Post a partir de un objeto Yeison
     * @param ob Objeto Yeison que contiene la información del Post
     * @return regresa el objeto tipo Post
     */
    public static Post deYeisonaPost(Yeison ob){
    return new Post(Integer.parseInt(ob.get("userId")), ob.get("title"), ob.get("body"), Integer.parseInt(ob.get("id")));
    }
    /**
     * Metodo para crear objetos tipo Comment a partir de un objeto Yeison  
     * @param ob Objeto Yeison que contiene la información del Comment
     * @return regresa el objeto tipo Comment
     */
    public static Comment deYeisonaComment(Yeison ob){
    return new Comment(Integer.parseInt(ob.get("postId")), ob.get("name"), ob.get("email"), ob.get("body"), Integer.parseInt(ob.get("id")));
    }
    /**
     * Metodo para añadir los objetos tipo User, Post y Comment al arbol
     * @param nivel Indica en que nivel deseamos agregar el objeto 1=User, 2= Post, 3=Comment
     * @param raiz La raiz del arbol donde deseamos agregar
     */
    public static void Agregar(int nivel, Nodo raiz) {
        switch (nivel) {
            case 1:
                NodoList usuarios = Reader.deArchivoALista(1, 23, "usuario");
                User a;
                while(usuarios!=null){
                    a = deYeisonaUser((Yeison)usuarios.getObject());
                    raiz.insertar(a, raiz);
                    Agregar(2, a);
                    usuarios=usuarios.link;
                }
                break;
            case 2:
                NodoList posts = Reader.deArchivoALista(1, 6, "posts");
                Post p;
                
                while(posts!=null){
                    p = deYeisonaPost((Yeison)posts.getObject());

                    if (p.getUserID() == raiz.getID()) {
                        raiz.insertar(p, raiz);
                        Agregar(3, p);
                        
                    }
                    if (p.getLinks()!=null && p.getUserID() != raiz.getID()) {
                        break;
                    }
                    posts=posts.link;
//
                }
                break;
            case 3:
                NodoList comentarios = Reader.deArchivoALista(1, 7, "comments");
                Comment c;

                while(comentarios!=null){
                    c = deYeisonaComment((Yeison) comentarios.getObject());

                    if (c.getPostID() == raiz.getID()) {
                        raiz.insertar(c, raiz);

                    }
                    comentarios=comentarios.link;
                }
                break;
            default:
                System.out.println("Solo existen 3 niveles. ");
        }
    }
}
