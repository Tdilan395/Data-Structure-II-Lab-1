package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 * Esta clase contiene todos los atributos y métodos de una compañia
 *
 * @author Dilan Triana
 */
public class Company {

    private final String name;
    private final String catchPhrase;
    private final String bs;

    /**
     * Método constructor parametrizado
     *
     * @param name nombre de la compañia
     * @param catchPhrase eslogan de la compañia
     * @param bs BS de la compañia
     */
    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    /**
     * Método para obtener el nombre de la compañia
     *
     * @return nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Método para retornar el eslogan de la compañia
     *
     * @return slogan
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * Método para retonar el bs
     *
     * @return bs
     */
    public String getBs() {
        return bs;
    }
    /**
     * Método para añadir la información de la compañia en una cadena de caracteres
     * @return String concatenado con la información de la compañia
     */
    public String printInfo() {
        return ("\n  Name: " + name + "\n  CatchPhrase: " + catchPhrase + " \n  Bs: " + bs);
    }

}
