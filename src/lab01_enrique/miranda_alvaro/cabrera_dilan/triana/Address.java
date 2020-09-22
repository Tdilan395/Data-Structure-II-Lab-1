package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 * Esta clase contiene todos los atributos y métodos de la dirección
 *
 * @author Dilan Triana
 */
public class Address {

    private final String street;
    private final String suite;
    private final String city;
    private final String zipCode;
    private final float[] geo;

    /**
     * Método constructor parametrizado
     *
     * @param street calle
     * @param suite
     * @param city ciudad
     * @param zipCode codigo postal
     * @param geo coordenadas
     */
    public Address(String street, String suite, String city, String zipCode, float[] geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipCode = zipCode;
        this.geo = geo;
    }

    /**
     * Método que permite obtener añadir toda la información de la dirección en
     * una cadena de caracteres.
     *
     * @return String concatenado con la información de la dirección.
     */
    public String printInfo() {
        return ("  Street: " + street + "\n  Suite: " + suite + "\n  City: " + city + "\n  ZipCode: " + zipCode + "\n  Geo :" + "\n    Lat: " + geo[0] + "\n    Lng: " + geo[1]);
    }

    /**
     * Método para obtener la calle.
     *
     * @return Calle
     */
    public String getStreet() {
        return street;
    }

    /**
     * Método para obtener la suite.
     *
     * @return suite
     */
    public String getSuite() {
        return suite;
    }

    /**
     * Método para obtener la ciudad.
     *
     * @return ciudad
     */
    public String getCity() {
        return city;
    }

    /**
     * Método para obtener el código Postal
     *
     * @return código postal
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Metódo para obtener las coordenas latitud y longitud
     *
     * @param i indice del vector, 1=latitud, 2= longitud
     * @return Latitud o Longitud.
     */
    public float getGeo(int i) {
        return geo[i];
    }

}
