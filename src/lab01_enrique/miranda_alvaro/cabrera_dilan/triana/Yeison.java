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
    private StringBuffer buff;
    public Yeison(String object){
        buff = new StringBuffer();
        buff.append(object);
    } 

    
    public String get(String key) {
        StringBuffer s = new StringBuffer();
        Pattern pat = Pattern.compile("(\""+key+"\": \\{)[\\s\\S]+(?=\\},\\n)|(\""+key+"\":).+(?=,)|(\""+key+"\": \\{)[\\s\\S]+(?=\\})");
        Matcher mat = pat.matcher(buff.toString());
        mat.find();
        s.append(mat.group().replace("\""+key+"\": ",""));
        return s.toString();
    }
}
