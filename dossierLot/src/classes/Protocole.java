package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author dyvia
 */
class Protocole {
    private int type;
    private String intitule;
    private String resultat;
    private int etat;
    private ArrayList<Etape> etapes;
    private ArrayList<Necessaire> necessaire;
    private String salle;
    private ArrayList<String> intervenants;

    public Protocole(int type, String intitule) {
        this.type = type;
        this.intitule = intitule;
        etapes=new ArrayList<Etape>();
        necessaire=new ArrayList<Necessaire>();
    }
    
    public void ajoutEtape(Etape etape){
        etapes.add(etape);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    void ajoutItem(Necessaire itemToAdd) {
        necessaire.add(itemToAdd);
    }

    
    
    
    
}


