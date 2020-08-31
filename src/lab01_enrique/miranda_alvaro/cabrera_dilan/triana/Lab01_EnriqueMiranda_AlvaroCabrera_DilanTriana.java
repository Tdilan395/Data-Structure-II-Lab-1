/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.ArrayList;
import static lab01_enrique.miranda_alvaro.cabrera_dilan.triana.Test1.deArchivoALista;
import org.json.JSONObject;

/**
 *
 * @author Domain
 */
public class Lab01_EnriqueMiranda_AlvaroCabrera_DilanTriana {

    /**
     * @param args the command line arguments
     */
    Nodo Raiz;
    public static void main(String[] args) {
        ArrayList<JSONObject> posts = Test1.deArchivoALista(1, 6, "posts");
        for (JSONObject post : posts) {
            System.out.println(post.get("id"));
        }
        ArrayList<JSONObject> comentarios=Test1.deArchivoALista(1, 7, "comments");
        for (JSONObject comentario : comentarios) {
            System.out.println(comentario.get("id"));
        }
        ArrayList<JSONObject> usuarios=Test1.deArchivoALista(1, 23, "usuario");
         ArrayList<JSONObject> addresses= new ArrayList();
         ArrayList<JSONObject> geos= new ArrayList();
         ArrayList<JSONObject> companies= new ArrayList();
         int c=0;
        for (JSONObject usuario : usuarios) {
            System.out.println(usuario.get("id"));
            addresses.add(new JSONObject(usuario.get("address").toString()));
            geos.add(new JSONObject(addresses.get(c).get("geo").toString()));
            companies.add(new JSONObject(usuario.get("company").toString()));
            c++;
        }
        for (JSONObject address : addresses) {
            System.out.println(address.get("street"));
        }
        for (JSONObject geo : geos) {
            System.out.println(geo);
        }
        for (JSONObject company : companies) {
            System.out.println(company.get("name"));
        }
    }

}
