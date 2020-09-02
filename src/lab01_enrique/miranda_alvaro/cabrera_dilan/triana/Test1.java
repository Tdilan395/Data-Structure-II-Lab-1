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
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class Test1 {

    public static ArrayList<JSONObject> deArchivoALista(int lim1, int lim2, String ruta) {
        ArrayList<JSONObject> objetos = new ArrayList();

        File f = new File(ruta + ".txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            System.out.println("sí pasé");
            int cont = 0;
            String linea;
            String object = "{";
            while ((linea = br.readLine()) != null) {
                if (cont > lim1 && cont < lim2) {
                    object += linea;
                }
                cont++;
                if (cont == lim2) {
                    JSONObject wey = new JSONObject(object + "}");
                    objetos.add(wey);
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

    public static User deJSONaUser(JSONObject ob) {
        JSONObject address = new JSONObject(ob.get("address").toString());
        JSONObject company = new JSONObject(ob.get("company").toString());
        JSONObject geo = new JSONObject(address.get("geo").toString());
        float ge[] = {geo.getFloat("lat"), geo.getFloat("lng")};
        Address a = new Address(address.getString("street"), address.getString("suite"), address.getString("city"), address.getString("zipcode"), ge);
        Company c = new Company(company.getString("name"), company.getString("catchPhrase"), company.getString("bs"));
        return new User(ob.getInt("id"),ob.getString("name"),ob.getString("username"),ob.getString("email"),ob.getString("phone"),ob.getString("website"),c,a);
    }

    public static Comment deJSONaComment(JSONObject ob) {
        return new Comment(ob.getInt("postId"),ob.getString("name"), ob.getString("email"), ob.getString("body"), ob.getInt("id"));
    }

    public static Post deJSONaPost(JSONObject ob) {
        
        return new Post(ob.getInt("userId"),ob.getString("title"), ob.getString("body"), ob.getInt("id"));
    }

    public void Agregar(int nivel, Nodo Raiz) {
        switch (nivel) {
            case 1:
                ArrayList<JSONObject> usuarios = Test1.deArchivoALista(1, 23, "usuario");
                User a;
                for (JSONObject usuario : usuarios) {
                    a = deJSONaUser(usuario);
//                    Nodo.insertar(a);
//                    Agregar(2,a);
                }
                break;
            case 2:
                ArrayList<JSONObject> posts = Test1.deArchivoALista(1, 6, "posts");
                Post p;
                for (JSONObject post : posts) {
                    p = deJSONaPost(post);
//                    if(p.getUserId()==Nodo.getId()){
//                    Nodo.insertar(p);
//                    Agregar(3,p);
//                    }
//                    if(!p.listIsEmpthy() && p.getUserId()!=Nodo.getId()){
//                        break;
//                    }
                }
                break;
            case 3:
                ArrayList<JSONObject> comentarios = Test1.deArchivoALista(1, 7, "comments");
                Comment c;
                for (JSONObject comentario : comentarios) {
                    c = deJSONaComment(comentario);
//                  if(Nodo.getId()==c.postID()){
//                    Nodo.insertar(c);
//                    }
                }
                break;
            default:
                System.out.println("Solo existen 3 niveles. ");
        }
    }
}
