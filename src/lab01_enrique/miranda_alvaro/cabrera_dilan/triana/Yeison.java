/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Domain
 */
public class Yeison {
    
    
    static public String[] atributos(ArrayList<String>lineas){
        Pattern p = Pattern.compile("\"(\\w+)\": ([[\\w|[\\w +]]\"|\\d]+),");
            Matcher m;
            int i=1;
        for (String linea : lineas) {
            m = p.matcher(linea);
            if (m.find()) {
                System.out.println("The value of " + m.group(i)+ " is " + m.group(i+1));
                i+=2;
            }
        }
    
    
    
        return null;
    } 
}
