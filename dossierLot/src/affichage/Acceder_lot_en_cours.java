/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichage;

import java.awt.Color;
import java.awt.Font;
import javafx.scene.input.KeyCode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Kenny
 */
public class Acceder_lot_en_cours extends JPanel{
    
    JButton b_acc_lot, b_retour;
    JLabel num_lot,scan_eti;
    String resultScan="";
    int wid, hei;
    
    public Acceder_lot_en_cours(int wi, int he) {
        
        //ImageIcon fleche = new ImageIcon("fleche.jpg");      
        
        scan_eti = new JLabel("<html><font size=15 style='Arial' color='white'>SCANNEZ ETIQUETTE</font></html>");
        b_acc_lot = new JButton("<html><font size=15 style='Arial' color='white'>Accèder au lot</font></html>");
        num_lot = new JLabel("<html><font size=15 style='Arial' color='white'>n° de lot :</font></html>");
        b_retour = new JButton("<html><font size=15 style='Arial' color='white'>R</font></html>");
        
        wid = wi;
        hei = he;
        initialisation();
    }
    
    private void initialisation() {
        
        
        this.setBackground(Color.WHITE);
        
        scan_eti.setBounds(wid*37/100, hei*10/100, wid*25/100, hei*20/100);
        scan_eti.setOpaque(true);
        scan_eti.setFont(new Font("Arial", Font.BOLD, 30));
        scan_eti.setHorizontalAlignment( SwingConstants.CENTER);
        scan_eti.setForeground(Color.white);
        scan_eti.setBackground(new java.awt.Color(0,156,218));
        this.add(scan_eti);
        
        b_acc_lot.setBounds(wid*37/100, hei*40/100, wid*25/100, hei*10/100);
        b_acc_lot.setBackground(new java.awt.Color(0,156,218));
        this.add(b_acc_lot);
        
        num_lot.setBounds(wid*25/100, hei*15/100, wid*10/100, hei*10/100);
        this.add(num_lot);
        
        b_retour.setBounds(wid*5/100, hei*85/100, wid*4/100, hei*6/100);
        b_retour.setBackground(new java.awt.Color(0,156,218));
        this.add(b_retour);
        
        this.setLayout(null);

    }

    void addLettre(char keyChar) {
        if(keyChar!='#'){
            this.resultScan=this.resultScan+keyChar;
            System.out.println(this.resultScan);
        } else if(keyChar=='~'){
            this.resultScan="";
            System.out.println("debutmot");
        } else {
            System.out.println("finmot");
            scan_eti.setText("<html><font size=15 style='Arial' color='white'>"+resultScan+"</font></html>");
            this.repaint();
        }
    }

}
