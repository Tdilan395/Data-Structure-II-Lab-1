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
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class Reader {

    public static ArrayList<Yeison> deArchivoALista(int lim1, int lim2, String ruta) {
        ArrayList<Yeison> objetos = new ArrayList();
        ArrayList<String> atributos = new ArrayList(); //DESCOMENTAR TODO LO RELACIONADO Y EL SOUT *******USERSSSSSSSSSSSSSSSSSE******** PARA PROBAR YEISON
        File f = new File(ruta + ".txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int cont = 0;
            String linea;
            String object = "{";
            atributos.add(object);
            while ((linea = br.readLine()) != null) {
                if (cont > lim1 && cont < lim2) {
                    atributos.add(linea);
                    object +="\n"+linea;
                }
                cont++;
                if (cont == lim2) {
                    object+= "\n}";
                    System.out.println("************************************USERSSSSSSSSSSSSSSSSSE*****************************************");
                    Yeison y= new Yeison(atributos);
                    atributos.clear();
                    objetos.add(y);
                    System.out.println(object);
                    object = "{";
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

    public static User deJSONaUser(String user) {
//        JSONObject address = new JSONObject(ob.get("address").toString());
//        JSONObject company = new JSONObject(ob.get("company").toString());
//        JSONObject geo = new JSONObject(address.get("geo").toString());
//        float ge[] = {geo.getFloat("lat"), geo.getFloat("lng")};
//        Address a = new Address(address.getString("street"), address.getString("suite"), address.getString("city"), address.getString("zipcode"), ge);
//        Company c = new Company(company.getString("name"), company.getString("catchPhrase"), company.getString("bs"));
        return null;//new User(ob.getInt("id"), ob.getString("name"), ob.getString("username"), ob.getString("email"), ob.getString("phone"), ob.getString("website"), c, a);
    }

//    public static Comment deJSONaComment(JSONObject ob) {
//        return new Comment(ob.getInt("postId"), ob.getString("name"), ob.getString("email"), ob.getString("body"), ob.getInt("id"));
//    }

//    public static Post deJSONaPost(JSONObject ob) {
//
//        return new Post(ob.getInt("userId"), ob.getString("title"), ob.getString("body"), ob.getInt("id"));
//    }

    public static void Agregar(int nivel, Nodo raiz) {
        switch (nivel) {
            case 1:
                ArrayList<Yeison> usuarios = Reader.deArchivoALista(1, 23, "usuario");
                User a;
                for (Yeison usuario : usuarios) {
                    //a = deJSONaUser()
//                    raiz.insertar(a, raiz);
//                    Agregar(2, a);
                }
                break;
            case 2:
                ArrayList<Yeison> posts = Reader.deArchivoALista(1, 6, "posts");
                Post p;
//
//                for (Nodo post : posts) {
//                    p = (Post)post;
////                    p.insertar(p, raiz);
////                    Agregar(3, raiz);
//
//                    if (p.getUserID() == raiz.getID()) {
//                        p.insertar(p, raiz);
//                        Agregar(3, p);
//
//                    }
//                    if (!p.getLinks().isEmpty() && p.getUserID() != raiz.getID()) {
//                        break;
//                    }
//
//                }
                break;
            case 3:
                //ArrayList<Nodo> comentarios = Reader.deArchivoALista(1, 7, "comments");
                Comment c;

//                for (Nodo comentario : comentarios) {
//                    c = (Comment) comentario;
//
//                    if (c.getPostID() == raiz.getID()) {
//                        c.insertar(c, raiz);
//
//                    }
//
//                }
//                break;
            default:
                System.out.println("Solo existen 3 niveles. ");
        }
    }
}
