/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase contiene todos los atributos y metodos de un Usuario
 *
 * @author Dilan Triana
 */
public class User extends Nodo {

    private final String name;
    private final String username;
    private final String email;
    private final String phone;
    private final String website;
    private final Company company;
    private final Address address;
    private final List ptr1;

    /**
     * Método constructor parametrizado
     *
     * @param ID id del usuario
     * @param name nombre del usuario
     * @param username nickname del usuario
     * @param email email del usuario
     * @param phone télefono del usuario
     * @param website website del usuario
     * @param c Compañia a la que pertence
     * @param a dirección del usuario
     */
    public User(int ID, String name, String username, String email, String phone, String website, Company c, Address a) {
        super(ID);
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        company = c;
        address = a;
        ptr1 = null;

    }

    /**
     * Método para obtener el nombre del usuario
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Método para obtener el nickname del usuario
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método para obtener el email del email del usuario
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método para obtener el número telefónico del usuario
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Método para obtener el website del usuario
     *
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Método para obtener la compañia del usuario
     *
     * @return company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Método para obtener la dirección del usuario
     *
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Método para añadir la información del usuario en una cadena de caracteres
     *
     * @return String concatenado con la información del usuario
     */
    @Override
    public String printInfo() {
        return ("Name: " + name + " \nUsername: " + username + " \nEmail: " + email + " \nPhone: " + phone + " \nWebsite: " + website + "\nCompany: " + company.printInfo() + "\nAddres: " + address.printInfo());
    }

    /**
     * Método para obtener la ruta simple. Esta información se utiliza en la
     * interfaz gráfica.
     *
     * @return String concatenada con el ID del usuario
     */
    @Override
    public String getSingleRoute() {
        return "User #" + this.getID();

    }

    /**
     * Método que se utiliza en la interfaz gráfica para realizar la lista de
     * usuarios. En caso de estar seleccionado el usuario, se mostrará una lista
     * vacia con la indicación para volver.
     *
     * @return String con la información a mostrar
     */
    @Override
    public String toString() {
        if (etiquetaSelection) {
            return "← ← ← Back ← ← ← ";
        }
        return "👤 #" + this.getID() + ": " + this.name;
    }

    /**
     * Método para realizar una busqueda en el segundo nivel del árbol. En este
     * caso se busca un post específico, según el parametro enviado.
     *
     * @param toSearch parametro del post que se desea encontrar: Id, title,
     * name, etc...
     * @param search valor del parametro que se desea buscar.
     * @see List#getObject()
     * @see List#addAll()
     * @return Retornar el nodo que cumpla con las especificaciones o nulo en
     * caso de no encontrarlo.
     */
    @Override
    public List search(String toSearch, String search) {//post
        Pattern pat = Pattern.compile(search);
        Matcher mat;
        List result = null;
        List p = this.getLinks();
        while (p != null) {
            Post post = (Post) p.getObject();
            switch (toSearch) {
                case "userId":
                    if (String.valueOf(post.getUserID()).equals(search)) {
                        result = List.add(result, post);
                    }
                    break;
                case "id":
                    if (String.valueOf(post.getID()).equals(search)) {
                        result = List.add(result, post);
                        if (result == null) {
                            return new List();
                        }
                        return result;
                    }
                    break;
                case "title":
                    mat = pat.matcher(post.getTitle());
                    if (mat.find()) {
                        result = List.add(result, post);
                    }
                case "body":
                    mat = pat.matcher(post.getBody());
                    if (mat.find()) {
                        result = List.add(result, post);
                    }
                    break;
                default:
                    System.out.println("No debería llegar aquí busqueda de post");
                    break;
            }
            p = p.link;
        }
        if (result == null) {
            return new List();
        }
        return result;
    }

    /**
     * Método para realizar una busqueda en el tercer nivel del árbol. En este
     * caso se busca un comentario específico, según el parametro enviado.
     *
     * @param searchTo parametro del comentario que se desea encontrar: Id,
     * body, email, etc...
     * @param search valor del parametro que se desea buscar.
     * @see List#getObject()
     * @see List#addAll()
     * @return Retornar el nodo que cumpla con las especificaciones o nulo en
     * caso de no encontrarlo.
     */
    @Override
    public List searchComment(String searchTo, String search) {
        List result = new List();
        List p = this.getLinks();

        while (p != null) {
            Post post = (Post) p.getObject();
            List c = post.search(searchTo, search);
            if (!c.isEmpty()) {
                result.addAll(c);
            }
            p = p.link;
        }
        return result;
    }

}
