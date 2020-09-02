/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 *
 * @author Domain
 */
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipCode;
    private float [] geo;

    public Address(String street, String suite, String city, String zipCode, float[] geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipCode = zipCode;
        this.geo = geo;
    }

    void printInfo() {
         //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
