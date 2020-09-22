
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Esta clase contiene todo lo relacionado para la obtención de los objetos leidos de un formato JSON.
 *  Yeison funciona a partir de una entrada de tipo String que es la distribución de lineas en formato String de un objeto con
    estructura JSON.
 * @author Dilan Triana
 */
public class Yeison {

   
    private final StringBuffer buff;
    /**
     * Método constructor parametrizado
     * @param object Objeto en formato JSON
     */
    public Yeison(String object) {
        buff = new StringBuffer();
        buff.append(object);
    }
    /**
     * Metodo para obtener el valor de los parametros del objeto en formato JSON
     * @param key Nombre del paramentro
     * @return El valor de parametro en tipo String
     */
   
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
