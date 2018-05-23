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
class Etape {
    private String intitule;
    private String description;
    private int etat;
    private boolean bloquant;
    private ArrayList<String> intervenants;
    private int type;
    private String pdfResult;
    private ArrayList<Machine> machines;

    Etape(Etape etape) {
        
    }

    public Etape(String intitule, String description, boolean bloquant) {
        this.intitule = intitule;
        this.description = description;
        this.bloquant = bloquant;
        this.type=1;
    }
    
    

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPdfResult() {
        return pdfResult;
    }

    public void setPdfResult(String pdfResult) {
        this.pdfResult = pdfResult;
        this.type=2;
    }
    
    
    
}
