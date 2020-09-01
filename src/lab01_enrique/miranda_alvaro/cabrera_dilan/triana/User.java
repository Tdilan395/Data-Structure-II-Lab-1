/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import javax.swing.JOptionPane;

/**
 *
 * @author Domain
 */
public class User extends Nodo{
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company;
    private Address address;

    public User(int ID) {
        super(ID);
    }
    
    
}
