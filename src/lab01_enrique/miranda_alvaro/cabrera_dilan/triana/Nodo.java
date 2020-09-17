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
            Nodo aux=(Nodo)p.getNodo();
            if(aux.getID()==id) return aux;
            else p=p.link;
            
        return null;
        }
    }
    
    public ArrayList<Nodo> searchPost(String searchTo, String search){
        ArrayList<Nodo> result = new ArrayList();
        for (Nodo user : links) {
            User u = (User) user;
            ArrayList<Nodo> p = u.search(searchTo, search);
            if(!p.isEmpty()){
                result.addAll(p);
            }
        }
        return result;
    }

    
    public NodoList getLinks(){
        return this.ptr;
    }
    
    public ArrayList<Nodo> searchComment(String searchTo, String search){
        for (Nodo user : links) {
            User u = (User) user;
            ArrayList<Nodo> c = u.searchComment(searchTo, search);
            if(c!= null){
                return c;
            }
        }
        return null;
    }
    
    public void printAllLinks(){
        NodoList p = ptr;
        while(p.link!=null){
            Nodo aux=(Nodo)p.getNodo();
             aux.printInfo();
             p=p.link;
        }
    }
    
    public ArrayList<Nodo> search(String toSearch, String search) {//user
        ArrayList<Nodo> result = new ArrayList();
        for (Nodo nodo : links) {
            User u = (User) nodo;
            switch (toSearch) {
                case "id":
                    if (u.getID() == Integer.parseInt(search)) {
                        result.add(u);
                        //return result;
                    }
                    break;
                case "name":
                    if (u.getName().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "username":
                    if (u.getUsername().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "email":
                    if (u.getEmail().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "dir-street":
                    if (u.getAddress().getStreet().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "dir-suite":
                    if (u.getAddress().getSuite().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "dir-city":
                    if (u.getAddress().getCity().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "dir-zipcode":
                    if (u.getAddress().getZipCode().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "geo-lat":
                    if (u.getAddress().getGeo(0) == Integer.parseInt(search)) {
                        result.add(u);
                    }
                    break;
                case "geo-lng":
                    if (u.getAddress().getGeo(1) == Integer.parseInt(search)) {
                        result.add(u);
                    }
                    break;
                case "phone":
                    if (u.getPhone().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "website":
                    if (u.getWebsite().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "comp-name":
                    if (u.getCompany().getName().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "comp-catchPharse":
                    if (u.getCompany().getCatchPhrase().equals(search)) {
                        result.add(u);
                    }
                    break;
                case "comp-bs":
                    if (u.getCompany().getBs().equals(search)) {
                        result.add(u);
                    }
                    break;
                default:
                    System.out.println("Aquí no deberia llegar busqueda de usuarios desde nodo raiz");
                    break;
            }
            
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
