/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author dyvia
 */

class Machine {
    
    private String nom;
    private ArrayList<Reglage> reglages;
    
//--------------- --------------- --------------- CONSTRUCTEURS --------------- --------------- ---------------
    
    public Machine(String nom) {
        this.nom = nom;
        reglages=new ArrayList<Reglage>();
    }
    
//--------------- --------------- --------------- GETTERS --------------- --------------- ---------------
    
    
    
//--------------- --------------- --------------- SETTERS --------------- --------------- ---------------
    
     public void ajoutReglage(String param, String valeur){
        reglages.add(new Reglage(param,valeur));
    }
}