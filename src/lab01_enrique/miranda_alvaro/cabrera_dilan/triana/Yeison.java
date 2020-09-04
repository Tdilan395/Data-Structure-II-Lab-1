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
    /*
    Yeison funciona a partir de una entrada de tipo Arraylist en donde cada elemento es la distribución de lineas en formato String de un objeto con
    estructura JSON.
    */
    
    static public String[] atributos(ArrayList<String>lineas){
        /*
            Los grupos están definidos entre parentesis
        
            Group #1: (\"(\\w+)\": ([\\d]+)) -> Toma todas las expresiones en las cuales se encuentre una palabra o más entre comillas, 
                                                dos puntos un espacio y una cantidad indefinida de digitos.
        
        
            Group #2: (\\w+) -> Toma todas las expresiones en las cuales se encuentre una palabra o más. 
                                (Se utiliza para saber el nombre del atributo);
        
        
            Group #3: ([\\d]+) -> Toma una cantidad indefinida de digitos. (Sólo se ha probado con valores enteros).
        
        
            Group #4: (\"(\\w+)\": \"(.+)\") -> Toma todas las expresiones en las cuales se encuentre una palabra o más entre comillas, 
                                                dos puntos un espacio y cualquier tipo de caracteres dentro de comillas.
        
        
            Group #5: (\\w+) -> Toma todas las expresiones en las cuales se encuentre una palabra o más. 
                                (Se utiliza para saber el nombre del atributo);
        
        
            Group #6: (.+) -> Toma cualquier tipo de caracteres. (Se utiliza para tomar el valor String de las variables)
        
        
            Group #7: (\"(\\w+)\": \\{) -> Toma todas las expresiones en las cuales se encuentre una palabra o más entre comillas
                                           dos puntos, un espacio y una llave abierta.
        
        
            Group #8: (\\w+) -> Toma todas las expresiones en las cuales se encuentre una palabra o más.
                                (Se utiliza para tomar el nombre de la clase de objeto que precede)
        
            Group #9: (}) -> Toma una llave cerrada; (Se utiliza para saber la cantidad de atributos que tiene un objeto que también es un atributo.
        */
        
        //
        Pattern p = Pattern.compile("(\"(\\w+)\": ([\\d]+))|(\"(\\w+)\": \"(.+)\")|(\"(\\w+)\": \\{)|(})");
            Matcher m;
            String[] []tempAtribCollector = new String[2][lineas.size()];
            int i = 0;
            int cantAtribut=0;
            boolean doraLaExploradora=false;
        for (String linea : lineas){
            m = p.matcher(linea);
            if (m.find()) {
                if(m.group(1)!=null||m.group(4)!=null){
                    
                    int variableGroup = (m.group(1)!=null)?2:5;
                    int valueVariable = (variableGroup==2)?3:6;
                    
                    System.out.println("The value of " + m.group(variableGroup)+ " is " + m.group(valueVariable));
                    tempAtribCollector[0][i]=m.group(variableGroup);
                    tempAtribCollector[1][i]=m.group(valueVariable);
                    i++;
                    if(doraLaExploradora)cantAtribut++;
                }
                else if(m.group(7)!=null){
                    System.out.println("**********************************");
                    System.out.println(m.group(8));
                    doraLaExploradora=true;
                    System.out.println("**********************************");
                }
            }
        }
    
    
    
        return null;
    } 
}
