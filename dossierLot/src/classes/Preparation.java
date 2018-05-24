package classes;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dyvia
 */
public class Preparation {
    
    private String numLot;
    private String numOrd;
    private int qte;
    private Date datePrep;
    private Date dateLim;
    private String photo;
    private String etiquette;
    private Medicament medicament;
    
//--------------- --------------- --------------- CONSTRUCTEURS --------------- --------------- ---------------
    
    Preparation(String numLot,Medicament medicament,String qteMed) {
        this.numLot=numLot;
        this.medicament=medicament;
        this.qte=Integer.parseInt(qteMed);
    }
    
//--------------- --------------- --------------- GETTERS --------------- --------------- ---------------
    
    public Medicament getMedicament() {
        return medicament;
    }
    
//--------------- --------------- --------------- SETTERS --------------- --------------- ---------------


//--------------- --------------- --------------- AFFICHAGE --------------- --------------- ---------------

    @Override
    public String toString() {
        return "Preparation{" + "numLot=" + numLot + ", numOrd=" + numOrd + ", qte=" + qte + ", datePrep=" + datePrep + ", dateLim=" + dateLim + ", photo=" + photo + ", etiquette=" + etiquette + ", medicament=" + medicament + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}