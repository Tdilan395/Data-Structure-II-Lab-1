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
 *Esta clase contiene todos los atributos y metodos de un Usuario
 * @author Dilan Triana
 */
public class User extends Nodo {

    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company;
    private Address address;
    private NodoList ptr1;

    public User(int ID, String name, String username, String email, String phone, String webside, Company c, Address a) {
        super(ID);
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = webside;
        company = c;
        address = a;
        ptr1=null;

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
    public String printInfo() {
        return ("Name: " + name + " \nUsername: " + username + " \nEmail: " + email + " \nPhone: " + phone + " \nWebsite: " + website + "\nCompany: " + company.printInfo() + "\nAddres: " + address.printInfo());
//        System.out.println("******************************************USER*********************************************************");
        //System.out.println(name + " \n- " + username + " \n- " +" \n- "+email+" \n- "+phone+" \n- "+website);
//        System.out.println("");
//        this.printAllLinks();

    }
 
    
    @Override
    public String getSingleRoute(){
        return "User #" + this.getID();
    
    }
    
    
    @Override
    public String toString() {
        if (etiquetaSelection) {
            return "← ← ← Back ← ← ← ";
        }
        return "👤 #" + this.getID() + ": " + this.name;
    }
    
    @Override
    public NodoList search(String toSearch, String search){//post
        Pattern pat = Pattern.compile(search);
        Matcher mat;
        NodoList result = null;
        NodoList p = this.getLinks();
        while(p!=null) {
            Post post = (Post)p.getObject();
            switch(toSearch){
                case "userId":
                    if (String.valueOf(post.getUserID()).equals(search)) {
                        result = NodoList.add(result, post);
                    }
                    break;
                case "id":
                    if (String.valueOf(post.getID()).equals(search)) {
                        result = NodoList.add(result, post);
                        if(result==null)return new NodoList();
                        return result;
                    }
                    break;
                case "title":
                    mat = pat.matcher(post.getTitle());
                    if(mat.find()){
                        result = NodoList.add(result, post);
                    }
                case "body":
                    mat = pat.matcher(post.getBody());
                    if(mat.find()){
                        result = NodoList.add(result, post);
                    }
                    break;
                default:
                    System.out.println("No debería llegar aquí busqueda de post");
                    break;
            }
            p=p.link;
        }
        if(result==null)return new NodoList();
        return result;
    }
    
    @Override
    public NodoList searchComment(String searchTo, String search){
        NodoList result = new NodoList();
        NodoList p = this.getLinks();
        
        while(p!=null){
            Post post = (Post) p.getObject();
            NodoList c =  post.search(searchTo, search);
            if(!c.isEmpty()){
                result.addAll(c);
            }
            p=p.link;
        }
        return result;
    }
    
}
