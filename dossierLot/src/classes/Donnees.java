/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.Necessaire;
import classes.Medicament;
import classes.Machine;
import classes.Etape;
import classes.Protocole;
import java.io.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author dyvia
 */
public class Donnees {
    
    private ArrayList<Medicament> medicaments;
    private int nbMedicaments=0;
    private String cheminJSON;
    private String cheminLots;
    private String cheminPDF;
    private Preparation prepEnCours;
    
//--------------- --------------- --------------- PARSAGE JSON --------------- --------------- --------------- 
    
    public boolean parseJSONMedicaments() throws ParseException{
        medicaments=new  ArrayList<Medicament>();
        JSONParser parser = new JSONParser();

        try {
            
            Object obj = parser.parse(new FileReader(cheminJSON+"medicaments.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray medicaments = (JSONArray)jsonObject.get("medicaments");
            nbMedicaments=medicaments.size();
            for(int i=0;i<medicaments.size();i++){
                JSONObject medicament = (JSONObject) medicaments.get(i);
                
                //---------- ---------- INFOS MEDICAMENT ---------- ----------
                int id=Integer.parseInt((String)medicament.get("id"));
                int type=Integer.parseInt((String)medicament.get("type"));
                String nom =(String)medicament.get("nom");
                String indication =(String)medicament.get("indication");
                String precautions=(String)medicament.get("precautions");
                int stockage=Integer.parseInt((String)medicament.get("stockage"));
                int joursUtilisation=Integer.parseInt((String)medicament.get("nbJours"));
                int conditionnement=Integer.parseInt((String)medicament.get("conditionnement"));
                
                
                //---------- ---------- PROTOCOLES MEDICAMENT ---------- ----------
                JSONArray protocolesArr=(JSONArray)medicament.get("protocoles");
                int[] protocolesTab=new int[protocolesArr.size()];
                int curseur=0;
                Iterator<String> iterator = protocolesArr.iterator();
                while (iterator.hasNext()) {
                    protocolesTab[curseur]=Integer.parseInt(iterator.next());
                    curseur++;
                }
                Medicament toAdd=new Medicament(id,type,nom,indication,precautions,stockage,joursUtilisation);
                //----- ----- AJOUT MEDICAMENT ----- -----
                this.medicaments.add(toAdd);
                for(int f=0;f<protocolesArr.size();f++){
                    parseJSONProtocole(this.medicaments.indexOf(toAdd),protocolesTab[f]);
                    //----- ----- AJOUT CONDITIONNEMENT ----- -----
                    if(this.medicaments.get(this.medicaments.indexOf(toAdd)).getProtocoles().get(this.medicaments.get(this.medicaments.indexOf(toAdd)).getProtocoles().size() - 1).getType()==1){
                        this.medicaments.get(this.medicaments.indexOf(toAdd)).getProtocoles().get(this.medicaments.get(this.medicaments.indexOf(toAdd)).getProtocoles().size() - 1).ajoutItem(parseJSONNecessaire(conditionnement,1));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public boolean parseJSONProtocole(int idMed,int idProt) throws ParseException{
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(cheminJSON+"protocoles.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray protocoles = (JSONArray)jsonObject.get("protocoles");
            for(int i=0;i<protocoles.size();i++){
                JSONObject protocole = (JSONObject) protocoles.get(i);
                int id=Integer.parseInt((String)protocole.get("id"));
                if(id==idProt){
                    
                    //---------- ---------- INFOS PROTOCOLE ---------- ----------
                    int type=Integer.parseInt((String)protocole.get("type"));
                    String intitule =(String)protocole.get("intitule");
                    String resultat;
                    
                    
                    Protocole toAdd=new Protocole(type,intitule);
                    
                    if(type==2){
                        resultat=(String)protocole.get("resultat");
                        toAdd.setResultat(resultat);
                    }
                    
                    //----- ----- MACHINE ----- -----
                    if(protocole.containsKey("machine")){
                        JSONObject machine=(JSONObject)protocole.get("machine");
                        String nomMachine=(String)machine.get("nom");
                        JSONArray reglages=(JSONArray)machine.get("reglages");
                        Machine machToAdd=new Machine(nomMachine);
                        for(int f=0;f<reglages.size();f++){
                            JSONObject reglage= (JSONObject) reglages.get(f);
                            String param=(String)reglage.get("parametre");
                            String valeur=(String)reglage.get("valeur");
                            machToAdd.ajoutReglage(param, valeur);
                        }
                    }

                    //----- ----- NECESSAIRE ----- -----
                    JSONArray necessaire=(JSONArray) protocole.get("necessaire");
                    for(int f=0;f<necessaire.size();f++){
                        JSONObject item= (JSONObject) necessaire.get(f);
                        int idItem=Integer.parseInt((String)item.get("id"));
                        
                        float qte=Float.parseFloat((String)item.get("qte"));
                        Necessaire itemToAdd=parseJSONNecessaire(idItem,qte);
                        toAdd.ajoutItem(itemToAdd);
                    }
                    
                    //----- ----- ETAPES ----- -----
                    JSONArray etapes=(JSONArray) protocole.get("etapes");
                    for(int f=0;f<etapes.size();f++){
                        JSONObject etape= (JSONObject) etapes.get(f);
                        String intituleEtape=(String)etape.get("intitule");
                        String descEtape=(String)etape.get("description");
                        boolean bloquant=Boolean.valueOf((String)etape.get("bloquant"));
                        Etape etapeToAdd=new Etape(intituleEtape,descEtape,bloquant);
                        if(etape.containsKey("resultat")){
                            String resultatEtape=(String)etape.get("resultat");
                            etapeToAdd.setPdfResult(resultatEtape);
                        } 
                        toAdd.ajoutEtape(etapeToAdd);
                    }
                    //----- -----AJOUT PROTOCOLE ----- -----
                    medicaments.get(idMed).ajoutProtocole(toAdd);
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    private Necessaire parseJSONNecessaire(int idItem,float qte) throws ParseException {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(cheminJSON+"necessaire.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray necessaire = (JSONArray)jsonObject.get("necessaire");
            for(int i=0;i<necessaire.size();i++){
                JSONObject item = (JSONObject) necessaire.get(i);
    
                int id=Integer.parseInt((String)item.get("id"));  
                
                if(id==idItem){
                    //---------- ---------- INFOS ITEM ---------- ----------
                    String nom=(String)item.get("nom");
                    int type=Integer.parseInt((String)item.get("type"));
                    Necessaire itemToAdd=new Necessaire(id,nom,qte,type);
                    
                    if(type==1){
                            //----- ----- CONDITIONNEMENT PRODUIT CHIMIQUE ----- -----
                            JSONArray conditionnement=(JSONArray)item.get("conditionnement");
                            int curseur=0;
                            Iterator<String> iterator = conditionnement.iterator();
                            while (iterator.hasNext()) {
                                int conditionnementToAdd=Integer.parseInt(iterator.next());
                                itemToAdd.ajoutConditionnement(conditionnementToAdd);
                            }
                            String unite=(String)item.get("type");
                    }
                    return itemToAdd;
                }                
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return null;
    }
    
//--------------- --------------- --------------- GETTERS --------------- --------------- ---------------
    
    public Medicament getMedicament(int id){
        return medicaments.get(id);
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public String getCheminJSON() {
        return cheminJSON;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public String getCheminLots() {
        return cheminLots;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public String getCheminPDF() {
        return cheminPDF;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public Medicament getItemNomme(String nom){
        for(int i=0;i<medicaments.size();i++){
            if(medicaments.get(i).getNom().equals(nom)){
                return medicaments.get(i);
            }
        }
        return null;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public ArrayList<String> getNomMedicaments(){
        ArrayList<String> listeNoms=new ArrayList<String>();
        for(int i=0;i<medicaments.size();i++){
            if(medicaments.get(i)!=null){
                listeNoms.add(medicaments.get(i).getNom());
            }
        }
    
    
        return listeNoms;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public Preparation getPrepEnCours() {
        return prepEnCours;
    }
    
    
//--------------- --------------- --------------- SETTERS --------------- --------------- ---------------

    public void setCheminJSON(String cheminJSON) {
        this.cheminJSON = cheminJSON;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public void setCheminLots(String cheminLots) {
        this.cheminLots = cheminLots;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------

    public void setCheminPDF(String cheminPDF) {
        this.cheminPDF = cheminPDF;
    }
    
    //---------- ---------- ---------- ---------- ---------- ----------
    
    public void setPrepEnCours(String numLot,String nomMed,String qteMed){
        this.prepEnCours=new Preparation(numLot,getItemNomme(nomMed),qteMed);
        //System.out.println(this.prepEnCours);
    }
    
    
}
