/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01_enrique.miranda_alvaro.cabrera_dilan.triana;

import java.util.Scanner;

/**
 *
 * @author Domain
 */
public class Lab01_EnriqueMiranda_AlvaroCabrera_DilanTriana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String responses = "", name;
        boolean running = true;
        Scanner s = new Scanner(System.in);

        System.out.print("Indique su nombre: ");
        name = s.nextLine();
        System.out.println("");
        AB arbol = new AB();
        System.out.println("********Leyendo la información********");
        System.out.println("********Poblando Arbol********");
        Reader.Agregar(1, arbol.raiz);
        System.out.println("********Arbol Creado********");
        //GUI_Tree GUI = new GUI_Tree("RRRR solutions", arbol.raiz, 900);
        while (running) {

            System.out.println("\nBienvenido " + name + "\n");
            System.out.println("Las opciones a su disposición son:\n"
                    + "1. Mostrar Información\n"
                    + "2. Buscar Usuario por ID\n"
                    + "3. Buscat Post por ID\n"
                    + "4. Buscar Comentario por ID\n"
                    + "5. Finalizar el programa\n");
            System.out.print("Selección: ");

            responses = s.nextLine();
            int i = -12;
            switch (responses) {
                case "1":
                    arbol.raiz.showAll();
                    break;
                case "2":
                    do {
                        System.out.print("ID: ");
                        responses = s.nextLine();

                        try {
                            i = Integer.parseInt(responses);
                        } catch (Exception e) {
                            System.out.println("\nID INVALIDA\n");
                        }
                    } while (i == -12);
                    try {
                        System.out.println(((Nodo) arbol.raiz.search("id", responses).getObject()).printInfo());
                    } catch (Exception e) {
                        System.out.println("No se encontró al usuario con id: " + responses);
                    }
                    break;
                case "3":
                    do {
                        System.out.print("ID: ");
                        responses = s.nextLine();

                        try {
                            i = Integer.parseInt(responses);
                        } catch (Exception e) {
                            System.out.println("\nID INVALIDA\n");
                        }
                    } while (i == -12);
                    try {
                        System.out.println(((Nodo) arbol.raiz.searchPost("id", responses).getObject()).printInfo());
                    } catch (Exception e) {
                        System.out.println("No se encontró al post con id: " + responses);
                    }
                    break;
                case "4":
                    do {
                        System.out.print("ID: ");
                        responses = s.nextLine();

                        try {
                            i = Integer.parseInt(responses);
                        } catch (Exception e) {
                            System.out.println("\nID INVALIDA\n");
                        }
                    } while (i == -12);
                    try {
                        System.out.println(((Nodo) arbol.raiz.searchComment("id", responses).getObject()).printInfo());
                    } catch (Exception e) {
                        System.out.println("No se encontró al comentario con id: " + responses);
                    }
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("\n\n****************OPCION INVALIDA****************\n\n");
                    break;
            }

        }

    }

}
