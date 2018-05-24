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
public class Protocole {
    
    private int type;
    private String intitule;
    private String resultat;
    private int etat;
    private ArrayList<Etape> etapes;
    private ArrayList<Necessaire> necessaire;
    private Necessaire conditionnement;
    private String salle;
    private ArrayList<String> intervenants;
    
//--------------- --------------- --------------- CONSTRUCTEURS --------------- --------------- ---------------

    public Protocole(int type, String intitule) {
        this.type = type;
        this.intitule = intitule;
        etapes=new ArrayList<Etape>();
        necessaire=new ArrayList<Necessaire>();
    }
    
//--------------- --------------- --------------- GETTERS --------------- --------------- ---------------
    
    public int getType() {
        return type;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public String getIntitule() {
        return intitule;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public String getResultat() {
        return resultat;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public int getEtat() {
        return etat;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public String getSalle() {
        return salle;
    }

    //---------- ---------- ---------- ---------- ---------- ----------
    
    public ArrayList<Necessaire> getNecessaire() {
        return necessaire;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public int getNbChimique(){
        int cpt=0;
        for(int i=0;i<necessaire.size();i++){
            if(necessaire.get(i).getType()==1){
                cpt++;
            }
            
        }
        return cpt;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public int getNbExcipient(){
         int cpt=0;
        for(int i=0;i<necessaire.size();i++){
            if(necessaire.get(i).getType()==2){
                cpt++;
            }
            
        }
        return cpt;
    
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public int getNbMateriel(){
         int cpt=0;
        for(int i=0;i<necessaire.size();i++){
            if(necessaire.get(i).getType()==3){
                cpt++;
            }
            
        }
        return cpt;
    }
    
    //--------------- --------------- --------------- SETTERS --------------- --------------- ---------------
    
    public void setSalle(String salle) {
        this.salle = salle;
    }
     
    //---------- ---------- ---------- ---------- ---------- ----------

    void ajoutItem(Necessaire itemToAdd) {
        necessaire.add(itemToAdd);
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public void setType(int type) {
        this.type = type;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public void setResultat(String resultat) {
        this.resultat = resultat;
    } 
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public void ajoutEtape(Etape etape){
        etapes.add(etape);
    }
}


