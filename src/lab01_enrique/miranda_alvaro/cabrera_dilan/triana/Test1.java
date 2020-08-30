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

    public static ArrayList<String> separar(String a) {
        ArrayList<String> textos = new ArrayList<>();
        int base = 0;
        for (int i = 2; i < a.length(); i++) {
            if (equi(a.substring(base, i)) == 0 && "},".equals(a.substring(i - 2, i))) {
                if (textos.size() == 0) {
                    textos.add(a.substring(1, i - 1));
                    base = i + 1;
                } else {
                    textos.add(a.substring(base, i - 1));
                    base = i + 1;
                }
            }
        }
        return textos;
    }

    public static int equi(String a) {
        int x = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '{') {
                x++;
            }
            if (a.charAt(i) == '}') {
                x--;
            }
        }
        return x;
    }
}
