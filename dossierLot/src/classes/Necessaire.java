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

public class Necessaire {
    
    private int id;
    private String numLot;
    private String dateLim;
    private String nom;
    private float qte;
    private int type;
    private ArrayList<Integer> conditionnement;
    
    
//--------------- --------------- --------------- CONSTRUCTEURS --------------- --------------- ---------------
    
    public Necessaire(int id,String nom, float qte, int type) {
        this.id=id;
        this.nom = nom;
        this.qte = qte;
        this.type = type;
        conditionnement=new ArrayList<Integer>();
    }
    
//--------------- --------------- --------------- GETTERS --------------- --------------- ---------------
    
    public int getId() {
        return id;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public String getNumLot() {
        return numLot;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public String getDateLim() {
        return dateLim;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public String getNom() {
        return nom;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public float getQte() {
        return qte;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public int getType() {
        return type;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public ArrayList<Integer> getConditionnement() {
        return conditionnement;
    }
    
    
//--------------- --------------- --------------- SETTERS --------------- --------------- ---------------

    void ajoutConditionnement(int conditionnementToAdd) {
       this.conditionnement.add(conditionnementToAdd);
    }
}
