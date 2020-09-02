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
        AB arbol = new AB();
   

        
        Test1.Agregar(1, arbol.raiz);
        Test1.Agregar(2, arbol.raiz.getLink(0));
        System.out.println(arbol.raiz.getLink(0).getLinks().size());
        arbol.print();
    }

}
