/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.ArrayList;

/**
 *
 * @author Domain
 */
public class Nodo {

    private final int ID;
    private ArrayList<Nodo> links;

    public Nodo(int ID) {
        this.ID = ID;
        links = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public Nodo getLink(int i) {
        return links.get(i);
    }

    /**
     *
     * @param nodo
     * @param Raiz
     * @since 0.2
     */
    public void insertar(Nodo nodo, Nodo Raiz) {
        Raiz.getLinks().add(nodo);
    }

    public ArrayList<Nodo> getLinks() {
        return this.links;
    }

    public void printAllLinks() {
        for (Nodo link : links) {
            link.printInfo();
        }
    }

    public void printInfo() {

    }

    @Override
    public String toString() {
        return "Users";
    }
    
    public Nodo searchPost(String searchTo, String search){
        for (Nodo user : links) {
            User u = (User) user;
            Post p = (Post)u.search(searchTo, search);
            if(p!= null){
                return p;
            }
        }
        return null;
    }
    
    public Nodo searchComment(String searchTo, String search){
        for (Nodo user : links) {
            User u = (User) user;
            Comment c = (Comment) u.searchComment(searchTo, search);
            if(c!= null){
                return c;
            }
        }
        return null;
    }
    
    public Nodo search(String toSearch, String search) {//user
        System.out.println("**************Busqueda de usuario**************");
        for (Nodo nodo : links) {
            User u = (User) nodo;
            switch (toSearch) {
                case "id":
                    if (u.getID() == Integer.parseInt(search)) {
                        return u;
                    }
                    break;
                case "name":
                    if (u.getName().equals(search)) {
                        return u;
                    }
                    break;
                case "username":
                    if (u.getUsername().equals(search)) {
                        return u;
                    }
                    break;
                case "email":
                    if (u.getEmail().equals(search)) {
                        return u;
                    }
                    break;
                case "dir-street":
                    if (u.getAddress().getStreet().equals(search)) {
                        return u;
                    }
                    break;
                case "dir-suite":
                    if (u.getAddress().getSuite().equals(search)) {
                        return u;
                    }
                    break;
                case "dir-city":
                    if (u.getAddress().getCity().equals(search)) {
                        return u;
                    }
                    break;
                case "dir-zipcode":
                    if (u.getAddress().getZipCode().equals(search)) {
                        return u;
                    }
                    break;
                case "geo-lat":
                    if (u.getAddress().getGeo(0) == Integer.parseInt(search)) {
                        return u;
                    }
                    break;
                case "geo-lng":
                    if (u.getAddress().getGeo(1) == Integer.parseInt(search)) {
                        return u;
                    }
                    break;
                case "phone":
                    if (u.getPhone().equals(search)) {
                        return u;
                    }
                    break;
                case "website":
                    if (u.getWebsite().equals(search)) {
                        return u;
                    }
                    break;
                case "comp-name":
                    if (u.getCompany().getName().equals(search)) {
                        return u;
                    }
                    break;
                case "comp-catchPharse":
                    if (u.getCompany().getCatchPhrase().equals(search)) {
                        return u;
                    }
                    break;
                case "comp-bs":
                    if (u.getCompany().getBs().equals(search)) {
                        return u;
                    }
                    break;
                default:
                    System.out.println("Aquí no deberia llegar busqueda de usuarios desde nodo raiz");
                    break;
            }
            
        }
        return null;
    }

    public String WriteInfo() {
        StringBuffer b = new StringBuffer();
        
        b.append("Nodo info");
        
        return b.toString();
    }
}
