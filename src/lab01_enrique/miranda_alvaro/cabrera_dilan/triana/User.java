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
public class User extends Nodo{
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company;
    private Address address;

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
    public String printInfo(){
        return (name + " \n- " + username + " \n- " +" \n- "+email+" \n- "+phone+" \n- "+website);
//        System.out.println("******************************************USER*********************************************************");
        //System.out.println(name + " \n- " + username + " \n- " +" \n- "+email+" \n- "+phone+" \n- "+website);
//        System.out.println("");
//        this.printAllLinks();
        
    }
    @Override
    public String toString(){
        if(etiquetaSelection)return "...";
        return "User #" + this.getID() + ": " + this.name;
    }
    
    @Override
    public Nodo search(String toSearch, String search){//post
        Pattern pat = Pattern.compile(search);
        Matcher mat;
        System.out.println("**************Busqueda de post**************");
        for (Nodo post : this.getLinks()) {
            Post p = (Post)post;
            switch(toSearch){
                case "userId":
                    if(p.getUserID() == Integer.parseInt(search)){
                        return p;
                    }
                    break;
                case "id":
                    if(p.getID() == Integer.parseInt(search)){
                        return p;
                    }
                    break;
                case "title":
                    mat = pat.matcher(p.getTitle());
                    if(mat.find()){
                        return p;
                    }
                case "body":
                    mat = pat.matcher(p.getBody());
                    if(mat.find()){
                        return p;
                    }
                    break;
                default:
                    System.out.println("No debería llegar aquí busqueda de post");
                    break;
            }
        }
        return null;
    }
    
    @Override
    public Nodo searchComment(String searchTo, String search){
        for (Nodo post : getLinks()) {
            Post p = (Post) post;
            Comment c = (Comment) p.search(searchTo, search);
            if(c != null){
                return c;
            }
        }
        return null;
    }
    
    @Override
    public String WriteInfo() {
        StringBuffer b = new StringBuffer();
        
        b.append("User info");
        
        return b.toString();
    }
}
