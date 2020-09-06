/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import Test_Units.treeUnits.GUI_Tree;
import java.util.ArrayList;


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
        
        Reader.Agregar(1, arbol.raiz);
        GUI_Tree GUI = new GUI_Tree("RRRR solutions", arbol.raiz, 600, 800);
        GUI.add(arbol.raiz.getLinks(), GUI.getRoot());
        System.out.println(arbol.raiz.getLinks().size());
        
        System.out.println(arbol.raiz.getLink(2).getLinks().size());
        
        
        System.out.println(arbol.raiz.getLink(2).getLink(0).getLinks().size());
        

    }

}
