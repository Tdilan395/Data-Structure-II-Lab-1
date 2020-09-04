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
        Pattern p = Pattern.compile("(\"(\\w+)\": ([\\d]+|\"[\\w ]+\"|\".+\"))|(\"(\\w+)\": \\{)");
            Matcher m;
            String[] []tempAtribCollector = new String[2][lineas.size()];
            int i = 0;
        for (String linea : lineas) {
            m = p.matcher(linea);
            if (m.find()) {
                if(m.group(1)!=null){
                    System.out.println("The value of " + m.group(2)+ " is " + m.group(3));
                    tempAtribCollector[0][i]=m.group(2);
                    tempAtribCollector[1][i]=m.group(3);
                    i++;
                }
                else if(m.group(4)!=null){
                    System.out.println("**********************************");
                    System.out.println(m.group(5));
                    System.out.println("**********************************");
                }
            }
        }
    
    
    
        return null;
    } 
}
