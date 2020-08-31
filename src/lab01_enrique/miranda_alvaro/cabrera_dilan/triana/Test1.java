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
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author user
 */

/* "id": 1,
"name": "Leanne Graham",
"username": "Bret",
"email": "Sincere@april.biz",
"address": {
"street": "Kulas Light",
"suite": "Apt. 556",
"city": "Gwenborough",
"zipcode": "92998-3874",
"geo": {
"lat": "-37.3159",
"lng": "81.1496"
}
},
"phone": "1-770-736-8031 x56442",
"website": "hildegard.org",
"company": {
"name": "Romaguera-Crona",
"catchPhrase": "Multi-layered client-server neural-net",
"bs": "harness real-time e-markets"
}
},*/
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
    
    public static User deJSONaUser(JSONObject ob){
    JSONObject address= new JSONObject(ob.get("address").toString());
    JSONObject company=new JSONObject(ob.get("company").toString());
    JSONObject geo= new JSONObject(address.get("geo").toString());
    float ge[]= {geo.getFloat("lat"),geo.getFloat("lng")};
    Address a= new Address(address.getString("street"), address.getString("suite"), address.getString("city"),address.getString("zipcode") , ge);
    Company c= new Company(company.getString("name"), company.getString("catchPhrase"), company.getString("bs"));
    return new User();
    } 
    
    public static Comment deJSONaComment(JSONObject ob){
        //id o postID?
        return new Comment(ob.getString("name"), ob.getString("email"), ob.getString("body"), ob.getInt("id"), null, null);
    }
    
    public static Post deJSONaPost(JSONObject ob){
        //id o UserId?
        return new Post(ob.getString("title"), ob.getString("body"), ob.getInt("id"), null, null);
    }
}