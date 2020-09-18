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
        return (Nodo)NodoList.getNodo(ptr, i);
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
        return result;
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
        return result;
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
        NodoList result = new NodoList();
        NodoList p = this.getLinks();
       
        while(p.link!=null){
            User u = (User) p.getObject();
            switch (toSearch) {
                case "id":
                    if (u.getID() == Integer.parseInt(search)) {
                        NodoList.add(result,u);
                        //return result;
                    }
                    break;
                case "name":
                    if (u.getName().equals(search)) {
                        NodoList.add(result,u);
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
                case "dir-street":
                    if (u.getAddress().getStreet().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "dir-suite":
                    if (u.getAddress().getSuite().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "dir-city":
                    if (u.getAddress().getCity().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "dir-zipcode":
                    if (u.getAddress().getZipCode().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "geo-lat":
                    if (u.getAddress().getGeo(0) == Integer.parseInt(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "geo-lng":
                    if (u.getAddress().getGeo(1) == Integer.parseInt(search)) {
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
                case "comp-catchPharse":
                    if (u.getCompany().getCatchPhrase().equals(search)) {
                        NodoList.add(result,u);
                    }
                    break;
                case "comp-bs":
                    if (u.getCompany().getBs().equals(search)) {
                        NodoList.add(result,u);
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
        if(etiquetaSelection)return "← ← ← ← ← ← ←";
        return "Users";
    }
}
