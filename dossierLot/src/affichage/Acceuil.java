/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichage;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author Kenny
 */
public class Acceuil extends JPanel{
    
JButton b_new_lot, b_acc_lot, b_gest_med, b_gest_prot;
int wid, hei;

    public Acceuil(int wi, int he) {

        b_new_lot = new JButton("<html><font size=15 style='Arial' color='white'>Nouveau Lot</font></html>");
        b_acc_lot = new JButton("<html><font size=15 style='Arial' color='white'>Acceder au lot en cours</font></html>");
        b_gest_med = new JButton("<html><font size=15 style='Arial' color='white'>Gestion de médicaments</font></html>");
        b_gest_prot = new JButton("<html><font size=15 style='Arial' color='white'>Gestion de protocoles</font></html>");
        
        wid = wi;
        hei = he;
        initialisation();
    }
    
    private void initialisation() {
        
        /*String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        }*/
        
        
        this.setBackground(Color.WHITE);
        
        //b_new_lot.setBounds(350, 150, 500, 200);
        b_new_lot.setBounds(wid*17/100, hei*15/100, wid*25/100, hei*20/100);
        b_new_lot.setBackground(new java.awt.Color(0,156,218));
        this.add(b_new_lot);
        
        b_acc_lot.setBounds(wid*57/100, hei*15/100, wid*25/100, hei*20/100);
        //b_acc_lot.setBounds(wid-850, hei-850, wid-1400, hei-800);
        b_acc_lot.setBackground(new java.awt.Color(0,156,218));
        this.add(b_acc_lot);
        
        b_gest_med.setBounds(wid*17/100, hei*60/100, wid*25/100, hei*20/100);
        b_gest_med.setBackground(new java.awt.Color(0,156,218));
        this.add(b_gest_med);
        
        b_gest_prot.setBounds(wid*57/100, hei*60/100, wid*25/100, hei*20/100);
        b_gest_prot.setBackground(new java.awt.Color(0,156,218));
        this.add(b_gest_prot);

        this.setLayout(null);

    }

}