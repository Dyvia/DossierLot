/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichage;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class Fab_Etapes extends JPanel{
    
    JButton b_prep_mat, b_inst_fab, b_verif_post_fab, b_retour;
    int wid, hei;

    public Fab_Etapes(int wi, int he) {
        
        b_prep_mat = new JButton("<html><font size=15 style='Arial' color='white'>Préparation Matériel</font></html>");
        b_inst_fab = new JButton("<html><font size=15 style='Arial' color='white'>Instructions Fabrication</font></html>");
        b_verif_post_fab = new JButton("<html><font size=15 style='Arial' color='white'>Vérifications Post-Fabrication</font></html>");
        b_retour = new JButton("<html><font size=15 style='Arial' color='white'>R</font></html>");
        
        wid = wi;
        hei = he;
        initialisation();
    }
    
    private void initialisation(){
        
        this.setBackground(Color.WHITE);
        
        b_prep_mat.setBounds(wid*31/100, hei*11/100, wid*37/100, hei*15/100);
        b_prep_mat.setBackground(new java.awt.Color(0,156,218));

        this.add(b_prep_mat);
        
        b_inst_fab.setBounds(wid*31/100, hei*39/100, wid*37/100, hei*15/100);
        b_inst_fab.setBackground(new java.awt.Color(0,156,218));
        this.add(b_inst_fab);
        
        b_verif_post_fab.setBounds(wid*31/100, hei*69/100, wid*37/100, hei*15/100);
        b_verif_post_fab.setBackground(new java.awt.Color(0,156,218));
        this.add(b_verif_post_fab);
        
        b_retour.setBounds(wid*5/100, hei*85/100, wid*4/100, hei*6/100);
        b_retour.setBackground(new java.awt.Color(0,156,218));
        this.add(b_retour);     
        
        this.setLayout(null);

    }

}

