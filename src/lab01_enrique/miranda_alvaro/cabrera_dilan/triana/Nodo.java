/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Esta clase contiene todos los atributos y metodos de un Nodo
 * @author Domain
 */
public class Nodo {

    private final int ID;
    private Nodo father;
    protected Boolean etiquetaSelection=false;
    private NodoList ptr;
    public Nodo(int ID) {
        this.ID = ID;
        ptr=null;
   
    }

    public int getID() {
        return ID;
    }
    /**
     * Metodo para obtener la dirección de alguno de los hijos del nodo
     * @param i el número del hijo que desea
     * @return Nodo i-esimo
     */
    public Nodo getLink(int i){
        return (Nodo)ptr.getNodo( i);
    }

    /**
     * Metodo para insertar Nodos
     * @param nodo nodo que se desea insertar
     * @param Raiz Raiz del arbol
     * @since 0.2
     */
    public void insertar(Nodo nodo, Nodo Raiz) {
        nodo.father=Raiz;
        ptr= NodoList.add(Raiz.getLinks(),nodo);
        
    }

    /**
     *
     * @param id
     * @param Raiz
     * @since 0.2
     * @return
     */
    public Nodo buscar(int id, Nodo Raiz){
        NodoList p = ptr;
        while(p!=null){
            Nodo aux=(Nodo)p.getObject();
            if(aux.getID()==id) return aux;
            else p=p.link;
        }
        return null;
    }
    
    public NodoList searchPost(String searchTo, String search){
        NodoList result = new NodoList();
        NodoList p = this.getLinks();
        while(p!=null) {
            User u = (User) p.getObject();
            NodoList post = u.search(searchTo, search);
            if(!post.isEmpty()){
                result.addAll(post);
            }
            p=p.link;
        }
        if(result.link==null)return new NodoList();
        return result.link;
    }

    
    public NodoList getLinks(){
        return this.ptr;
    }
    
    public NodoList searchComment(String searchTo, String search){
        NodoList result = new NodoList();
        NodoList p = this.getLinks();
        while(p!=null){
            User u = (User) p.getObject();
            NodoList c = u.searchComment(searchTo, search);
            if(!c.isEmpty()){
                result.addAll(c);
            }
            p=p.link;
        }
        if(result.link == null || result.link.link==null)return new NodoList();
        return result.link.link;
    }
    
    public void printAllLinks(){
        NodoList p = ptr;
        while(p.link!=null){
            Nodo aux=(Nodo)p.getObject();
             aux.printInfo();
             p=p.link;
        }
    }
    
    public NodoList search(String toSearch, String search) {//user
        Pattern pat = Pattern.compile(search);
        Matcher mat;
        NodoList result = null;
        NodoList p = this.getLinks();
       
        while(p!=null){
            User u = (User) p.getObject();
            switch (toSearch) {
                case "id":
                    if (String.valueOf(u.getID()).equals(search)) {
                        result = NodoList.add(result,u);
                        if(result==null) return new NodoList();
                        return result;
                    }
                    break;
                case "name":
                    mat = pat.matcher(u.getName());
                    if (mat.find()) {
                        result = NodoList.add(result, u);
                    }
                    break;
                case "username":
                    if (u.getUsername().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "email":
                    if (u.getEmail().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "dir-city":
                    if (u.getAddress().getCity().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "phone":
                    if (u.getPhone().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "website":
                    if (u.getWebsite().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "comp-name":
                    if (u.getCompany().getName().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                default:
                    System.out.println("Aquí no deberia llegar busqueda de usuarios desde nodo raiz");
                    break;
            }
            p=p.link;
        }
        if (result == null)return new NodoList();
        return result;
    }


    public String printInfo() {
        return "";
    }
    
    public String getSingleRoute(){
        return "";
    }
//    public String WriteInfo() {
//        StringBuffer b = new StringBuffer();
//        
//        b.append("Nodo info");
//        
//        return b.toString();
//    }

    public Nodo getFather() {
        return father;
    }
    
    @Override
    public String toString(){
        if(etiquetaSelection)return "← ← ← Back ← ← ← ";
        return "Users";
    }
}
