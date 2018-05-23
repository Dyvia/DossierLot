/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Kenny
 */
public class Instruction_Fab extends JPanel {
    
    JLabel info;
    JLabel quant, name, scan_1, l_nece, l_proto, l_etap, etiquet;
    JButton b_valider, b_retour, b_photo;
    JScrollBar scroll;
    JPanel protocole, necessaire;
    int wid, hei;

    public Instruction_Fab(int wi, int he) {
        
        info = new JLabel ("Instructions pour la préparation de 20 Collyres");
        quant = new JLabel ();
        name = new JLabel ("GENTAMICINE 80mg - 2ml");
        scan_1 = new JLabel ("SCAN");
        l_etap = new JLabel ();
        etiquet = new JLabel ("ETIQUETTE");
        b_valider = new JButton ("<html><font size=15 style='Arial' color='white'>Valider</font></html>");
        b_photo = new JButton ("<html><font size=15 style='Arial' color='white'>Photo</font></html>");
        b_retour = new JButton ("<html><font size=15 style='Arial' color='white'>R</font></html>");
        l_nece = new JLabel ("Nécessaire");
        l_proto = new JLabel ("Protocole");
        necessaire = new JPanel();
        protocole = new JPanel();
        
        wid = wi;
        hei = he;
        initialisation();
    }
    
    private void initialisation(){
        
       this.setBackground(Color.WHITE);
        
        info.setBounds(0, 0, wid, hei*5/100);
        info.setBackground(new java.awt.Color(0,156,218));
        info.setOpaque(true);
        info.setFont(new Font("Arial", Font.PLAIN, 25));
        info.setHorizontalAlignment( SwingConstants.LEFT);
        info.setForeground(Color.white);
        this.add(info);
        
        l_nece.setBounds((int) (wid*0.5/100), hei*10/100, (int) (wid*40/100 - wid*0.5/100), hei*5/100);
        l_nece.setBackground(new java.awt.Color(0,156,218));
        l_nece.setOpaque(true);
        l_nece.setFont(new Font("Arial", Font.PLAIN, 15));
        l_nece.setHorizontalAlignment( SwingConstants.CENTER);
        l_nece.setForeground(Color.white);
        l_nece.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        this.add(l_nece);
        
        l_proto.setBounds((int) (wid*40/100 + wid*0.5/100), hei*10/100, wid*60/100 - wid*2/100, hei*5/100);
        l_proto.setBackground(new java.awt.Color(0,156,218));
        l_proto.setOpaque(true);
        l_proto.setFont(new Font("Arial", Font.PLAIN, 15));
        l_proto.setHorizontalAlignment( SwingConstants.CENTER);
        l_proto.setForeground(Color.white);
        l_proto.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        this.add(l_proto);
        
        etiquet.setBounds(wid*37/100, hei*10/100, wid*25/100, hei*20/100);
        etiquet.setOpaque(true);
        etiquet.setFont(new Font("Arial", Font.BOLD, 30));
        etiquet.setHorizontalAlignment( SwingConstants.CENTER);
        etiquet.setForeground(Color.white);
        etiquet.setBackground(new java.awt.Color(0,156,218));
        this.add(etiquet);
      
        b_valider.setBounds(wid*45/100, hei*80/100, wid*10/100, hei*8/100);
        b_valider.setBackground(new java.awt.Color(0,156,218));
        this.add(b_valider);
        
        b_photo.setBounds(wid*60/100, hei*80/100, wid*10/100, hei*8/100);
        b_photo.setBackground(new java.awt.Color(0,156,218));
        this.add(b_photo);
        
        b_retour.setBounds(wid*5/100, hei*85/100, wid*4/100, hei*6/100);
        b_retour.setBackground(new java.awt.Color(0,156,218));
        this.add(b_retour);
        
        necessaire.setBackground(Color.WHITE);
        necessaire.setLayout(new BoxLayout(necessaire, BoxLayout.PAGE_AXIS));
        necessaire.setBounds((int) (wid*0.5/100), hei*15/100, (int) (wid/2 - wid*0.5/100), hei*40/100);
        this.add(necessaire);
       

        protocole.setBackground(Color.WHITE);
        protocole.setLayout(new BoxLayout(protocole, BoxLayout.PAGE_AXIS));
        protocole.setPreferredSize(new Dimension(wid*60/100 - wid*5/100, 5000));
        protocole.setAutoscrolls(true);

        
        JScrollPane scrollPane = new JScrollPane(necessaire);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds((int) (wid*0.5/100), hei*15/100, (int) (wid*40/100 - wid*0.5/100), hei*40/100);
        
        JScrollPane scrollPane2 = new JScrollPane(protocole);
        scrollPane2.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds((int) (wid*40/100 + wid*0.5/100), hei*15/100, wid*60/100 - wid*2/100, hei*60/100); 

        //this.setPreferredSize(new Dimension(1000, 200));
        
        necessaire.setLayout(new GridBagLayout());
        protocole.setLayout(new GridBagLayout());

        this.add(scrollPane, new GridBagLayout());
        this.add(scrollPane2, new GridBagLayout());
        
        GridBagConstraints grid_nece = new GridBagConstraints();
        GridBagConstraints grid_proto = new GridBagConstraints();
        
        grid_nece.weighty = 1;

        for (int i = 0; i < 100; i++) {
             
            quant = new JLabel ();
            name = new JLabel ("GENTAMICINE 80mg - 2ml");
            scan_1 = new JLabel ("SCAN");

            grid_nece.weightx = 0;
    
            quant.setText("" + i);
            quant.setOpaque(true);
            quant.setHorizontalAlignment(SwingConstants.CENTER); 
            quant.setFont(new Font("Arial", Font.BOLD, 17));
            quant.setBackground(new java.awt.Color(0,156,218));
            quant.setForeground(Color.WHITE);
            quant.setPreferredSize(new Dimension(40, 30));
            quant.setBorder(new LineBorder(Color.BLUE));
            grid_nece.gridx = 0;
            grid_nece.gridy = i;
            necessaire.add(quant, grid_nece);

            name.setText("GENTAMICINE 80mg - 2ml");
            name.setOpaque(true);
            name.setHorizontalAlignment(SwingConstants.CENTER); 
            name.setFont(new Font("Arial", Font.PLAIN, 17));
            name.setBackground(new java.awt.Color(0,156,218));
            name.setForeground(Color.WHITE);
            name.setPreferredSize(new Dimension(300, 30));
            name.setBorder(new LineBorder(Color.BLUE));
            grid_nece.gridx = 1;
            grid_nece.gridy = i;
            necessaire.add(name, grid_nece);
            
            grid_nece.fill = GridBagConstraints.HORIZONTAL;
          
            scan_1.setText("SCAN");
            scan_1.setOpaque(true);
            scan_1.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_1.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_1.setBackground(Color.WHITE);
            scan_1.setForeground(new java.awt.Color(0,156,218));
            scan_1.setPreferredSize(new Dimension(200, 30));
            scan_1.setBorder(new LineBorder(Color.BLUE));
            grid_nece.gridx = 2;
            grid_nece.gridy = i;
            necessaire.add(scan_1, grid_nece);

        }
                 
        
        
        grid_proto.weighty = 1;
        
        for (int i = 0; i < 100; i++) {
            
            l_etap = new JLabel ();

            grid_proto.weightx = 0;
    
            l_etap.setText("bllblblblbl");
            l_etap.setOpaque(true);
            l_etap.setHorizontalAlignment(SwingConstants.CENTER); 
            l_etap.setFont(new Font("Arial", Font.BOLD, 17));
            l_etap.setBackground(Color.WHITE);
            l_etap.setForeground(new java.awt.Color(0,156,218));
            l_etap.setPreferredSize(new Dimension(wid*60/100, hei*10/100));
            l_etap.setBorder(new LineBorder(Color.BLUE));
            grid_proto.gridy = i;
            protocole.add(l_etap, grid_proto);

 
        }
        
        this.setLayout(null);
    }

}
