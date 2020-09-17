/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Domain
 */
public class Yeison {

   
    private StringBuffer buff;

    public Yeison(String object) {
        buff = new StringBuffer();
        buff.append(object);
    }

    public String get(String key) {
        StringBuffer s = new StringBuffer();
        Pattern p = Pattern.compile("\"");

        Pattern pat = Pattern.compile("(\"" + key + "\": \\{)[\\s\\S]+(?=\\},\\n)|(\"" + key + "\":).+(?=,)|(\"" + key + "\": \\{)[\\s\\S]+(?=\\}\\n)|(\"" + key + "\":).+(?=\\n)");
        Matcher mat = pat.matcher(buff.toString());
        if (mat.find()) {
            if (mat.group(1) != null || mat.group(3) != null) {
                s.append(mat.group().replace("\"" + key + "\": ", ""));
            } else {
                Matcher m = p.matcher(mat.group());
                if (m.find()) {
                    s.append(mat.group().replace("\"" + key + "\": ", "").replace("\"", ""));
                }
            }
        }
        return s.toString();
    }
}
