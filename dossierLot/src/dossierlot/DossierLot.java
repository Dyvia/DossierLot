/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dossierlot;
import affichage.Fenetre;
import classes.Donnees;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
/**
 *
 * @author dyvia
 */
public class DossierLot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        /*Barcode code=new Barcode(sc.nextLine());
        if(code.analyse()==true){
            System.out.println(code.getDateLim());
            System.out.println(code.getNumLot());
        } else {
            System.out.println("CODE BARRE INVALIDE");
        }*/
        
        Donnees donnees=new Donnees();
        donnees.setCheminJSON("C://Users//dyvia//OneDrive//Bureau//Stage//Projets//Gestion_de_lots_dématérialisée//Données//");
        donnees.setCheminLots("C://Users//dyvia//OneDrive//Bureau//Stage//Projets//Gestion_de_lots_dématérialisée//netbeans//FILE TEST ZONE//");
        donnees.setCheminPDF("C://Users//dyvia//OneDrive//Bureau//Stage//Projets//Gestion_de_lots_dématérialisée//netbeans//FILE TEST ZONE//");
        donnees.parseJSONMedicaments();
        System.out.println(donnees.getNomMedicaments());
        
         
        Fenetre f = new Fenetre(donnees);
        f.setVisible(true);
    }
    
}
