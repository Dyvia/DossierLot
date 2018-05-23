/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichage;

import classes.Donnees;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

 
 
public class Fenetre extends JFrame implements ActionListener,KeyListener, ComponentListener{

    Acceuil acceuil;
    
    Acceder_lot_en_cours access; 
    New_Lot nouveau_lot;
    Gestion_medoc gest_medoc = new Gestion_medoc();
    Gestion_prot gest_prot = new Gestion_prot();
    
    Etapes etapes;
    Fab_Etapes fab_etapes;
    Stockage stockage = new Stockage();
    
    Prep_Materiel prep_materiel;

    private Donnees donnees;
   
    public Fenetre(Donnees donnees){
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        this.donnees=donnees;

        //super("Dossier de lot");
        this.setTitle("Dossier de lot");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
        int hauteur = (int)tailleEcran.getHeight(); 
        int largeur = (int)tailleEcran.getWidth();
        this.setPreferredSize(new Dimension(largeur,hauteur));
        this.setSize(largeur, hauteur);
        this.addComponentListener(this);
         
        Image icone = Toolkit.getDefaultToolkit().getImage("FRI_PHARM.png");
        this.setIconImage(icone);
        
        initialisation(largeur, hauteur);
   
    }
    
    void initialisation(int w, int h){
        
        System.out.println(this.getPreferredSize().width + " et " + this.getPreferredSize().height);
        
         //Acceuil 
        acceuil = new Acceuil(w, h);
        this.acceuil.b_new_lot.addActionListener(this);
        this.acceuil.b_acc_lot.addActionListener(this);
        this.acceuil.b_gest_med.addActionListener(this);
        this.acceuil.b_gest_prot.addActionListener(this);
        
        //Acceder_lot_en_cours
        access = new Acceder_lot_en_cours(w, h);
        this.access.b_retour.addActionListener(this);
        this.access.b_acc_lot.addActionListener(this);
        
        //New_Lot
        nouveau_lot = new New_Lot(donnees.getNomMedicaments(), w, h);
        this.nouveau_lot.b_retour.addActionListener(this);
        this.nouveau_lot.b_new_lot.addActionListener(this);
        
        //Gestion_medoc
        this.gest_medoc.b_retour.addActionListener(this);
        
        //Gestion_prot
        this.gest_prot.b_retour.addActionListener(this);
        
        //Etapes
        etapes = new Etapes(w, h);
        this.etapes.b_cont.addActionListener(this);
        this.etapes.b_fab.addActionListener(this);
        this.etapes.b_stock.addActionListener(this);
        this.etapes.b_valid_c.addActionListener(this);
        this.etapes.b_valid_f.addActionListener(this);
        this.etapes.b_valid_s.addActionListener(this);
        this.etapes.b_retour.addActionListener(this);
        
        //Fab_Etapes
        fab_etapes = new Fab_Etapes(w, h);
        this.fab_etapes.b_retour.addActionListener(this);
        this.fab_etapes.b_prep_mat.addActionListener(this);
        this.fab_etapes.b_inst_fab.addActionListener(this);
        this.fab_etapes.b_verif_post_fab.addActionListener(this);
        
        //Stockage
        this.stockage.b_stocka.addActionListener(this);
        this.stockage.b_retour.addActionListener(this);
        
        //Prep_Materiel
        prep_materiel = new Prep_Materiel(w, h);
        this.prep_materiel.b_retour.addActionListener(this);

        this.setContentPane(acceuil);
        
        this.pack();
    }
    
    //Acceuil
    public void AcceuilToAccess(){
        this.setContentPane(access);
        this.revalidate();
        /*System.out.println(this.getWidth() + " et " + this.getHeight());
        acceuil.wid = this.getWidth();
        acceuil.hei = this.getHeight();
        this.setContentPane(acceuil);*/
    }
    
    public void AcceuilToNewLot(){
        this.setContentPane(nouveau_lot);
        this.revalidate();
    }
    
    public void AcceuilToGestMed(){
        this.setContentPane(gest_medoc);
        this.revalidate();
    }
    
    public void AcceuilToGestProt(){
        this.setContentPane(gest_prot);
        this.revalidate();
    }
     
    public void backAcceuil(){
        this.setContentPane(this.acceuil);
        this.revalidate();
    }
     
    //Acceder_lot_en_cours
    public void AccessToEtapes(){
        this.setContentPane(this.etapes);
        this.revalidate();
    }
    
    public void backAccess(){
        this.setContentPane(this.access);
        this.revalidate();
    }
    
    //Etapes
    public void EtapesToFab(){
        this.setContentPane(this.fab_etapes);
        this.revalidate();
    }
    
    public void EtapesToCont(){
        this.setContentPane(this.fab_etapes);
        this.revalidate();
    }
    
    public void EtapesToStock(){
        this.setContentPane(this.stockage);
        this.revalidate();
    }
    
    public void backEtapes(){
        this.setContentPane(this.etapes);
        this.revalidate();
    }
    
    //Fab_Etapes
    public void Fab_EtapeToPrep_Materiel(){
        this.setContentPane(this.prep_materiel);
        this.revalidate();
    }
    
    public void backFabEtapes(){
        this.setContentPane(this.fab_etapes);
        this.revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent clic) {
        requestFocus();
        //Acceuil
        if (clic.getSource() == acceuil.b_new_lot){
            Fenetre.this.AcceuilToNewLot();
        }
        if (clic.getSource() == acceuil.b_acc_lot){
            Fenetre.this.AcceuilToAccess();
        }
        if (clic.getSource() == acceuil.b_gest_med){
            Fenetre.this.AcceuilToGestMed();
        }
        if (clic.getSource() == acceuil.b_gest_prot){
            Fenetre.this.AcceuilToGestProt();
        }
        
        //Acceder_lot_en_cours
        if (clic.getSource() == access.b_retour){
            Fenetre.this.backAcceuil();
        }
        if (clic.getSource() == access.b_acc_lot){
            Fenetre.this.AccessToEtapes();
        }  
        
        //New_Lot
        if (clic.getSource() == nouveau_lot.b_retour){
            Fenetre.this.backAcceuil();
        }
        
        if(clic.getSource()==nouveau_lot.b_new_lot){
            System.out.println(nouveau_lot.getItemSelect());
            
            try {
                nouveau_lot.creerLot(donnees.getCheminLots(),donnees.getCheminPDF());
            } catch (IOException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
        //Gestion_medoc
        if (clic.getSource() == gest_medoc.b_retour){
            Fenetre.this.backAcceuil();
        }
        
        //Gestion_prot
        if (clic.getSource() == gest_prot.b_retour){
            Fenetre.this.backAcceuil();
        }
        
        //Etapes
        if (clic.getSource() == etapes.b_fab){
            Fenetre.this.EtapesToFab();
        }
        if (clic.getSource() == etapes.b_cont){
            Fenetre.this.EtapesToCont();
        }
        if (clic.getSource() == etapes.b_stock){
            Fenetre.this.EtapesToStock();
        }
        if (clic.getSource() == etapes.b_retour){
            Fenetre.this.backAccess();
        }
        
        //Fab_Etapes
        if (clic.getSource() == fab_etapes.b_prep_mat){
            Fenetre.this.Fab_EtapeToPrep_Materiel();
        }
        if (clic.getSource() == fab_etapes.b_retour){
            Fenetre.this.backEtapes();
        }
        
        //Stockage
        if (clic.getSource() == stockage.b_stocka){
            Fenetre.this.backAcceuil();
        }
        if (clic.getSource() == stockage.b_retour){
            Fenetre.this.backEtapes();
        }
        
        //Prep_Materiel
        if (clic.getSource() == prep_materiel.b_retour){
            Fenetre.this.backFabEtapes();
        }

        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("key typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(this.getContentPane()==this.access){
            if(e.getKeyCode()>=48&&e.getKeyCode()<=90){
                //System.out.println(e.getKeyText(e.getKeyCode()));
                //System.out.println(e.getKeyChar());
                System.out.println(e.getKeyCode());
                this.access.addLettre(e.getKeyChar());
            }
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("key released");
    }

    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println("Resized");
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        System.out.println("Resized");    
    }

    @Override
    public void componentShown(ComponentEvent e) {
        System.out.println("Resized");
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        System.out.println("Resized");
    }
    
   
    
    

    
    
}