package classes;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dyvia
 */

public class Medicament {
    
    private int id;
    private int type;
    private String nom;
    private String indication;
    private String precautions;
    private int stockage;
    private int joursUtilisation;
    private ArrayList<Protocole> protocoles;
    
//--------------- --------------- --------------- CONSTRUCTEURS --------------- --------------- ---------------
    
    public Medicament() {
        
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public Medicament(int id, int type, String nom, String indication, String precautions, int stockage, int joursUtilisation) {
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.indication = indication;
        this.precautions = precautions;
        this.stockage = stockage;
        this.joursUtilisation = joursUtilisation;
        protocoles=new ArrayList<Protocole>();
    }
    
//--------------- --------------- --------------- GETTERS --------------- --------------- ---------------
    
    public int getId() {
        return id;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
     public int getType() {
        return type;
    }
     
    //---------- ---------- ---------- ---------- ---------- ----------
     
    public String getNom() {
        return nom;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public String getIndication() {
        return indication;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public String getPrecautions() {
        return precautions;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public int getStockage() {
        return stockage;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public int getJoursUtilisation() {
        return joursUtilisation;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public ArrayList<Protocole> getProtocoles() {
        return protocoles;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public Protocole getFabProtocole(){
        for(int i=0;i<protocoles.size();i++){
            if(protocoles.get(i).getType()==1){
                return protocoles.get(i);
            }
        }
        return null;
    }
    
//--------------- --------------- --------------- SETTERS --------------- --------------- ---------------

    public void setData(int id, int type, String nom, String indication, String precautions, int stockage, int joursUtilisation){
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.indication = indication;
        this.precautions = precautions;
        this.stockage = stockage;
        this.joursUtilisation = joursUtilisation;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public void setId(int id) {
        this.id = id;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public void setType(int type) {
        this.type = type;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public void setNom(String nom) {
        this.nom = nom;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public void setIndication(String indication) {
        this.indication = indication;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public void setStockage(int stockage) {
        this.stockage = stockage;
    }

    //---------- ---------- ---------- ---------- ---------- ----------

    public void setJoursUtilisation(int joursUtilisation) {
        this.joursUtilisation = joursUtilisation;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    void ajoutProtocole(Protocole toAdd) {
        protocoles.add(toAdd);
    }
    
//--------------- --------------- --------------- AFFICHAGE --------------- --------------- ---------------
    
    @Override
    public String toString() {
        return "Medicament{" + "id=" + id + ", type=" + type + ", nom=" + nom + ", indication=" + indication + ", precautions=" + precautions + ", stockage=" + stockage + ", joursUtilisation=" + joursUtilisation + ", protocoles=" + protocoles + '}';
    }

    
    
    
    
}
