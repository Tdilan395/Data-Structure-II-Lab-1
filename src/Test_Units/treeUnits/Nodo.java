/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Units.treeUnits;

/**
 *
 * @author Domain
 */
public class Nodo {
    String name;
    
    public Nodo(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    }
    public String papara(){
        return "papa";
    }
}
