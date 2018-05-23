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
public class Stockage extends JPanel {
    
    JButton b_stocka, b_retour;
    JLabel info;

    public Stockage() {
        
        b_stocka = new JButton("<html><font size=15 style='Arial' color='white'>Stockage effectué</font></html>");
        info = new JLabel("Stockage Collyre");
        b_retour = new JButton("<html><font size=15 style='Arial' color='white'>R</font></html>");
        
        initialisation();
    }
    
    private void initialisation(){
        
        this.setBackground(Color.WHITE);
        
        b_stocka.setBounds(800, 600, 400, 100);
        b_stocka.setBackground(new java.awt.Color(0,156,218));
        this.add(b_stocka);
        
        info.setBounds(0, 0, 1900, 20);
        info.setBackground(new java.awt.Color(0,156,218));
        this.add(info);
        
        b_retour.setBounds(20, 900, 50, 50);
        b_retour.setBackground(new java.awt.Color(0,156,218));
        this.add(b_retour);
        
        this.setLayout(null);
    }
}
