/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichage;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class Etapes extends JPanel {
    
    JButton b_fab, b_cont, b_stock, b_valid_f, b_valid_c, b_valid_s, b_retour ;
    JLabel info;
    int wid, hei;

    public Etapes(int wi, int he) {
        
        b_fab = new JButton("<html><font size=15 style='Arial' color='white'>Fabrication</font></html>");
        b_cont = new JButton("<html><font size=15 style='Arial' color='white'>Contrôles</font></html>");
        b_stock = new JButton("<html><font size=15 style='Arial' color='white'>Stockage</font></html>");
        b_valid_f = new JButton("<html><font size=15 style='Arial' color='white'>validation</font></html>");
        b_valid_c = new JButton("<html><font size=15 style='Arial' color='white'>validation</font></html>");
        b_valid_s = new JButton("<html><font size=15 style='Arial' color='white'>validation</font></html>");
        b_retour = new JButton("<html><font size=15 style='Arial' color='white'>R</font></html>");
        info = new JLabel("<html><font size=15 style='Arial' color='white'>Collyre gentamicine 20180409/C</font></html>");
        
        wid = wi;
        hei = he;
        initialisation();
    }
    
    private void initialisation(){
        
       this.setBackground(Color.WHITE);
        b_fab.setBounds(wid*31/100, hei*11/100, wid*37/100, hei*15/100);
        //b_fab.setBounds(600, 150, 700, 150);
        b_fab.setBackground(new java.awt.Color(0,156,218));
        this.add(b_fab);
        
        b_cont.setBounds(wid*31/100, hei*39/100, wid*37/100, hei*15/100);
        //b_cont.setBounds(600, 400, 700, 150);
        b_cont.setBackground(new java.awt.Color(0,156,218));
        this.add(b_cont);
        
        b_stock.setBounds(wid*31/100, hei*69/100, wid*37/100, hei*15/100);
        //b_stock.setBounds(600, 650, 700, 150);
        b_stock.setBackground(new java.awt.Color(0,156,218));
        this.add(b_stock);
        
        b_valid_f.setBounds(wid*77/100, hei*15/100, wid*15/100, hei*8/100);
        b_valid_f.setBackground(new java.awt.Color(0,156,218));
        this.add(b_valid_f);
        
        b_valid_c.setBounds(wid*77/100, hei*43/100, wid*15/100, hei*8/100);
        b_valid_c.setBackground(new java.awt.Color(0,156,218));
        this.add(b_valid_c); 
        
        b_valid_s.setBounds(wid*77/100, hei*73/100, wid*15/100, hei*8/100);
        b_valid_s.setBackground(new java.awt.Color(0,156,218));
        this.add(b_valid_s);
        
        b_retour.setBounds(wid*5/100, hei*85/100, wid*4/100, hei*6/100);
        b_retour.setBackground(new java.awt.Color(0,156,218));
        this.add(b_retour);
        
        this.setLayout(null);

    }
}
