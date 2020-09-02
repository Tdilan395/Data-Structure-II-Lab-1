/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.ArrayList;
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
        ArrayList<User>usuarios = new ArrayList<>();
        ArrayList<JSONObject> yeisonList = Test1.deArchivoALista(1, 23, "usuario");
        for (JSONObject yeisonObj : yeisonList) {
            usuarios.add(Test1.deJSONaUser(yeisonObj));
        }
        
        for (User u: usuarios) {
            System.out.println(u.getID() + "    " + u.getName());
        }
        
    }

}
