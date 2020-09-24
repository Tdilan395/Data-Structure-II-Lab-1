
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;


/**
 *Clase Main, se encarga de crear el árbol, poblarlo y añadirlo a la interfaz gráfica. 
 * @author Dilan Triana
 */
public class Lab01_EnriqueMiranda_AlvaroCabrera_DilanTriana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AB arbol = new AB();
        Reader.Agregar(1, arbol.raiz);
        GUI_Tree GUI = new GUI_Tree("RRRR solutions", arbol.raiz, 900);
      
    
    }
}
