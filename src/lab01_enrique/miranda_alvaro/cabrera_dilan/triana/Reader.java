/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author user
 */
public class Reader {

    public static NodoList deArchivoALista(int lim1, int lim2, String ruta) {
        NodoList objetos=null;
        File f = new File(ruta + ".txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int cont = 0;
            String linea;
            String object = "";
            while ((linea = br.readLine()) != null) {
                if (cont >= lim1 && cont <= lim2) {
                    object +=linea+"\n";
                }
                cont++;
                if (cont == lim2) {
                   object+= "},"; 
                    Yeison y = new Yeison(object);
                    objetos=NodoList.add(objetos, y);
                    object = "";
                    cont = 0;
                }
            }
            return objetos;

        } catch (FileNotFoundException ex) {
            System.out.println("sí pasé FILO NOT");

            return objetos;
        } catch (IOException ex) {
            System.out.println("sí pasé IOEX");

            return objetos;
        }
    }

    public static User deYeisonaUser(Yeison ob) {
        Yeison address = new Yeison(ob.get("address"));
        Yeison company = new Yeison(ob.get("company"));
      Yeison geo = new Yeison(address.get("geo"));
        float ge[] = {Float.parseFloat(geo.get("lat")), Float.parseFloat(geo.get("lng"))};
       Address a = new Address(address.get("street"), address.get("suite"), address.get("city"), address.get("zipcode"), ge);
       Company c = new Company(company.get("name"), company.get("catchPhrase"), company.get("bs"));
          return  new User(Integer.parseInt(ob.get("id")), ob.get("name"), ob.get("username"), ob.get("email"), ob.get("phone"), ob.get("website"), c, a);
    }

    public static Post deYeisonaPost(Yeison ob){
    return new Post(Integer.parseInt(ob.get("userId")), ob.get("title"), ob.get("body"), Integer.parseInt(ob.get("id")));
    }
    
    public static Comment deYeisonaComment(Yeison ob){
    return new Comment(Integer.parseInt(ob.get("postId")), ob.get("name"), ob.get("email"), ob.get("body"), Integer.parseInt(ob.get("id")));
    }

    public static void Agregar(int nivel, Nodo raiz) {
        switch (nivel) {
            case 1:
                NodoList usuarios = Reader.deArchivoALista(1, 23, "usuario");
                System.out.println(NodoList.getNodo(usuarios,0));
                User a;
                while(usuarios!=null){
                    a = deYeisonaUser((Yeison)usuarios.getObject());
                    raiz.insertar(a, raiz);
                    Agregar(2, a);
                    usuarios=usuarios.link;
                }
                break;
            case 2:
                NodoList posts = Reader.deArchivoALista(1, 6, "posts");
                Post p;
                
                while(posts!=null){
                    p = deYeisonaPost((Yeison)posts.getObject());

                    if (p.getUserID() == raiz.getID()) {
                        raiz.insertar(p, raiz);
                        Agregar(3, p);
                        
                    }
                    if (p.getLinks()!=null && p.getUserID() != raiz.getID()) {
                        break;
                    }
                    posts=posts.link;
//
                }
                break;
            case 3:
                NodoList comentarios = Reader.deArchivoALista(1, 7, "comments");
                Comment c;

                while(comentarios!=null){
                    c = deYeisonaComment((Yeison) comentarios.getObject());

                    if (c.getPostID() == raiz.getID()) {
                        raiz.insertar(c, raiz);

                    }
                    comentarios=comentarios.link;
                }
                break;
            default:
                System.out.println("Solo existen 3 niveles. ");
        }
    }
}
