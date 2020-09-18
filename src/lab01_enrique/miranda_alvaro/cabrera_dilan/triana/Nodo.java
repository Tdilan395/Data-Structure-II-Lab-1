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
    public Nodo getLink(int i){
        return (Nodo)ptr.getNodo( i);
    }

    /**
     *
     * @param nodo
     * @param Raiz
     * @since 0.2
     */
    public void insertar(Nodo nodo, Nodo Raiz) {
        nodo.father=Raiz;
        ptr= NodoList.add(Raiz.getLinks(),nodo);
        
    }
    
    public NodoList searchPost(String searchTo, String search){
        NodoList result = new NodoList();
        NodoList p = this.getLinks();
        while(p!=null) {
            User u = (User) p.getObject();
            NodoList post = u.search(searchTo, search);
            if(!post.isEmpty()){
                result = result.addAll(post);
            }
            p=p.link;
        }
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
                result = result.addAll(c);
            }
            p=p.link;
        }
        return result.link;
    }
    
    public NodoList search(String toSearch, String search) {//user
        NodoList result = null;
        NodoList p = this.getLinks();
       
        while(p.link!=null){
            User u = (User) p.getObject();
            switch (toSearch) {
                case "id":
                    if (u.getID() == Integer.parseInt(search)) {
                        result = NodoList.add(result,u);
                        return result;
                    }
                    break;
                case "name":
                    if (u.getName().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "username":
                    if (u.getUsername().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "email":
                    if (u.getEmail().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "dir-street":
                    if (u.getAddress().getStreet().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "dir-suite":
                    if (u.getAddress().getSuite().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "dir-city":
                    if (u.getAddress().getCity().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "dir-zipcode":
                    if (u.getAddress().getZipCode().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "geo-lat":
                    if (u.getAddress().getGeo(0) == Integer.parseInt(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "geo-lng":
                    if (u.getAddress().getGeo(1) == Integer.parseInt(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "phone":
                    if (u.getPhone().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "website":
                    if (u.getWebsite().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "comp-name":
                    if (u.getCompany().getName().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "comp-catchPharse":
                    if (u.getCompany().getCatchPhrase().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                case "comp-bs":
                    if (u.getCompany().getBs().equals(search)) {
                        result = NodoList.add(result,u);
                    }
                    break;
                default:
                    System.out.println("Aquí no deberia llegar busqueda de usuarios desde nodo raiz");
                    break;
            }
            p=p.link;
        }
        return result;
    }


    public String printInfo() {
        return "";
    }
    
    public String getSingleRoute(){
        return "";
    }

    public Nodo getFather() {
        return father;
    }
    
    @Override
    public String toString(){
        if(etiquetaSelection)return "← ← ← ← ← ← ←";
        return "Users";
    }
    
    public void showAll(){
        NodoList p = getLinks();
        while(p != null){
            Nodo n = (Nodo)p.getObject();
            System.out.println("*************_👤 #"+n.getID()+"_*************");
            System.out.println(((Nodo)p.getObject()).printInfo()+"\n");
            n.showAll();
            p = p.link;
        }
    }
}
