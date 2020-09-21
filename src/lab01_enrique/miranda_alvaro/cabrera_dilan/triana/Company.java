/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 *Esta clase contiene todos los atributos y metodos de una compañia
 * @author Dilan Triana
 */
public class Company {
   private String name;
   private String catchPhrase;
   private String bs;
   /**
    * Metodo constructor parametrizado
    * @param name nombre de la compañia
    * @param catchPhrase eslogan de la compañia
    * @param bs 
    */
    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
    /**
     * Metodo para obtener el nombre de la compañia
     * @return el nombre
     */
    public String getName() {
        return name;
    }
    /**
     * Metodo para retornar el eslogan de la compañia
     * @return el slogan 
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }
    /**
     * Metodo para retonar el bs
     * @return  bs
     */
    public String getBs() {
        return bs;
    }

    public String printInfo() {
        return ("\n  Name: "+name+"\n  CatchPhrase: "+catchPhrase+" \n  Bs: "+bs);
    }
   
   
}
