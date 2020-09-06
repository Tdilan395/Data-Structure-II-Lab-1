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
import java.util.ArrayList;


/**
 *
 * @author user
 */
public class Reader {

    public static ArrayList<Yeison> deArchivoALista(int lim1, int lim2, String ruta) {
        ArrayList<Yeison> objetos = new ArrayList();
        ArrayList<String> atributos = new ArrayList(); //DESCOMENTAR TODO LO RELACIONADO Y EL SOUT *******USERSSSSSSSSSSSSSSSSSE******** PARA PROBAR YEISON
        File f = new File(ruta + ".txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int cont = 0;
            String linea;
            String object = "";
            atributos.add(object);
            while ((linea = br.readLine()) != null) {
                if (cont >= lim1 && cont <= lim2) {
                    atributos.add(linea);
                    object +=linea+"\n";
                }
                cont++;
                if (cont == lim2) {
                   object+= "},";
                    //System.out.println("************************************USERSSSSSSSSSSSSSSSSSE*****************************************");
                    Yeison y = new Yeison(object);
//                    Yeison a = new Yeison(y.get("address"));
//                    Yeison g = new Yeison(a.get("geo"));
//                    System.out.println(g.get("lat"));
                    
                    //atributos.clear();
                    objetos.add(y);
                 // System.out.println(object);
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
                ArrayList<Yeison> usuarios = Reader.deArchivoALista(1, 23, "usuario");
                User a;
                for (Yeison usuario : usuarios) {
                    a = deYeisonaUser(usuario);
                    raiz.insertar(a, raiz);
                    Agregar(2, a);
                }
                break;
            case 2:
                ArrayList<Yeison> posts = Reader.deArchivoALista(1, 6, "posts");
                Post p;

                for (Yeison post : posts) {
                    p = deYeisonaPost(post);
                    p.insertar(p, raiz);
                    Agregar(3, raiz);

                    if (p.getUserID() == raiz.getID()) {
                        p.insertar(p, raiz);
                        Agregar(3, p);

                    }
                    if (!p.getLinks().isEmpty() && p.getUserID() != raiz.getID()) {
                        break;
                    }
//
                }
                break;
            case 3:
                ArrayList<Yeison> comentarios = Reader.deArchivoALista(1, 7, "comments");
                Comment c;

                for (Yeison comentario : comentarios) {
                    c = deYeisonaComment(comentario);

                    if (c.getPostID() == raiz.getID()) {
                        c.insertar(c, raiz);

                    }

                }
                break;
            default:
                System.out.println("Solo existen 3 niveles. ");
        }
    }
}
