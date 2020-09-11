/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

/**
 *Esta clase contiene todos los atributos y metodos de un Usuario
 * @author Dilan Triana
 */
public class User extends Nodo{
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company;
    private Address address;

    /**
     * Metodo constructor parametrizado
     * @param ID el id del usuario  
     * @param name nombre del usuario
     * @param username sobrenombre del usuario  
     * @param email correo electronico del usuario
     * @param phone telefono celular del usuario
     * @param webside sitio web del usuario
     * @param c compañia del usuario
     * @param a dirección del usuario
     */
    public User(int ID, String name, String username, String email, String phone, String webside, Company c, Address a) {
        super(ID);
        this.name=name;
        this.username=username;
        this.email=email;
        this.phone=phone;
        this.website=webside;
        company=c;
        address=a;
        
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }
    
    @Override
    public void printInfo(){
        
        System.out.println("******************************************USER*********************************************************");
        System.out.println(name + " - " + username + " - " +" - "+email+" - "+phone+" - "+website);
        System.out.println("");
        this.printAllLinks();
        
    }
}
