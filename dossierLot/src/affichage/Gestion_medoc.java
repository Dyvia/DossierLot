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
public class Gestion_medoc extends JPanel{
    
    JLabel travaux;
    JButton b_retour;

    public Gestion_medoc() {
        travaux = new JLabel("En travaux");
        b_retour = new JButton("<html><font size=15 style='Arial' color='white'>R</font></html>");
        
        initialisation();
    }
    
    private void initialisation(){
        
        this.setBackground(Color.WHITE);
        
        travaux.setBounds(350, 150, 500, 200);
        travaux.setBackground(new java.awt.Color(0,156,218));
        this.add(travaux);
        
        b_retour.setBounds(20, 900, 50, 50);
        b_retour.setBackground(new java.awt.Color(0,156,218));
        this.add(b_retour);
        
        this.setLayout(null);
    } 
}
