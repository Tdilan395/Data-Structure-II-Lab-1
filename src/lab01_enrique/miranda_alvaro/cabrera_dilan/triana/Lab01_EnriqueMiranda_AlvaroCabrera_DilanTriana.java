/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import Test_Units.treeUnits.GUI_Tree;
import Test_Units.testeo;


/**
 *
 * @author Domain
 */
public class Lab01_EnriqueMiranda_AlvaroCabrera_DilanTriana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AB arbol = new AB();
        testeo t = new testeo();
        t.setVisible(true);
        Reader.Agregar(1, arbol.raiz);
        testeo.Raiz = arbol.raiz;
        GUI_Tree GUI = new GUI_Tree("RRRR solutions", arbol.raiz, 600, 700);
        GUI.add(arbol.raiz.getLinks(), GUI.getRoot());
        //System.out.println(arbol.raiz.getLinks().size());
        //System.out.println(arbol.raiz.getLink(2).getLinks().size());
        //System.out.println(arbol.raiz.getLink(2).getLink(0).getLinks().size());
        //GUI.escribir();

    }

}
