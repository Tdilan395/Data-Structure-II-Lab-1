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
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<JSONObject> objetos = deArchivoALista();
       
        System.out.println(objetos.get(0).get("userId"));
    
    }

     public static ArrayList<JSONObject> deArchivoALista() {
        ArrayList<JSONObject> objetos = new ArrayList();
        
        File f = new File("pedidos.txt");
      
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            System.out.println("sí pasé");
            int cont=0;
            String linea;
            String object="{";
            while((linea = br.readLine()) != null) {
                if(cont>1 && cont<6){
                    object+=linea;
                }
                cont++;
                
                /*String cliente = datos[0];
                String repartidor = datos[1];
                String direccion = datos[2];
                String comida = datos[3];
                String costo = datos[4];*/
                if(cont==7){
                    System.out.println(object);
                JSONObject wey = new JSONObject(object+"}");
                
                objetos.add(wey);
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
     public static ArrayList<String> separar(String a){
        ArrayList<String> textos = new ArrayList<>();
        int base = 0;
        for (int i = 2; i < a.length(); i++) {
            if(equi(a.substring(base, i))==0 && "},".equals(a.substring(i-2,i))){
                if(textos.size() == 0){
                    textos.add(a.substring(1, i-1));
                    base = i+1;
                }else{
                    textos.add(a.substring(base, i-1));
                    base = i+1;
                }
            }
        }
        return textos;
    }
    
    public static int equi(String a){
        int x=0;
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i)=='{'){
                    x++;
                }
                if(a.charAt(i)=='}'){
                    x--;
                }
            }
        return x;
    }
}
