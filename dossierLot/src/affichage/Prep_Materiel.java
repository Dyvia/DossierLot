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
public class Prep_Materiel extends JPanel {
    
    JLabel info;
    JLabel quant, name, scan_1, scan_2, l_form, l_mat;
    JButton b_valider, b_retour;
    JScrollBar scroll;
    JPanel princ_act, exci, condi, mat, formule;
    int wid, hei;

    public Prep_Materiel(int wi, int he) {
        
        info = new JLabel ("Matériel nécessaire à la préparation de 20 Collyres");
        quant = new JLabel ();
        name = new JLabel ("GENTAMICINE 80mg - 2ml");
        scan_1 = new JLabel ("SCAN");
        scan_2 = new JLabel ("SCAN");
        b_valider = new JButton ("<html><font size=15 style='Arial' color='white'>Valider</font></html>");
        b_retour = new JButton ("<html><font size=15 style='Arial' color='white'>R</font></html>");
        l_form = new JLabel ("Formule");
        l_mat = new JLabel ("Matériel");
        formule = new JPanel();
        princ_act = new JPanel();
        exci = new JPanel();
        condi = new JPanel();
        mat = new JPanel();
        
        wid = wi;
        hei = he;
        initialisation();
    }
    
    private void initialisation(){
        
        int var1 = 2;
        int var2 = 10;
        int var3= 50;
        
        int max;
        
        int test1;
        if (var1*40+40 < hei*28/100){
            test1 = hei*28/100;
        }
        else { test1 = var1*40+40; }
        
        max = test1;
        
        int test2;
        if (var2*40+40 < hei*28/100){
            test2 = hei*28/100;
        }
        else { test2 = var2*40+40; }
        
        if (test1 < test2){
            max = test2;
        }
        
        int test3;
        if (var3*40+40 < hei*28/100){
            test3 = hei*28/100;
        }
        else { test3 = var3*40+40; }
        
        if (test2 < test3){
            max = test3;
        }
        
        max = max + 40;
        
        this.setBackground(Color.WHITE);
        
        info.setBounds(0, 0, wid, hei*5/100);
        info.setBackground(new java.awt.Color(0,156,218));
        info.setOpaque(true);
        info.setFont(new Font("Arial", Font.PLAIN, 25));
        info.setHorizontalAlignment( SwingConstants.LEFT);
        info.setForeground(Color.white);
        this.add(info);
        
        l_form.setBounds((int) (wid*0.5/100), hei*10/100, (int) (wid/2 - wid*0.5/100), hei*5/100);
        l_form.setBackground(new java.awt.Color(0,156,218));
        l_form.setOpaque(true);
        l_form.setFont(new Font("Arial", Font.PLAIN, 15));
        l_form.setHorizontalAlignment( SwingConstants.CENTER);
        l_form.setForeground(Color.white);
        l_form.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        this.add(l_form);
        
        l_mat.setBounds((int) (wid/2 + wid*0.5/100), hei*10/100, wid/2 - wid*2/100, hei*5/100);
        l_mat.setBackground(new java.awt.Color(0,156,218));
        l_mat.setOpaque(true);
        l_mat.setFont(new Font("Arial", Font.PLAIN, 15));
        l_mat.setHorizontalAlignment( SwingConstants.CENTER);
        l_mat.setForeground(Color.white);
        l_mat.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        this.add(l_mat);  
        
        b_valider.setBounds(wid*45/100, hei*80/100, wid*10/100, hei*8/100);
        b_valider.setBackground(new java.awt.Color(0,156,218));
        this.add(b_valider);
        
        b_retour.setBounds(wid*5/100, hei*85/100, wid*4/100, hei*6/100);
        b_retour.setBackground(new java.awt.Color(0,156,218));
        this.add(b_retour);
        
        formule.setBackground(Color.WHITE);
        formule.setLayout(new BoxLayout(formule, BoxLayout.PAGE_AXIS));
        formule.setBounds((int) (wid*0.5/100), hei*15/100, (int) (wid/2 - wid*0.5/100), hei*60/100);
        this.add(formule);

        princ_act.setBackground(Color.WHITE);
        //princ_act.setBounds(0, hei*9/100, wid/2 - wid*5/100, hei*28/100);
        princ_act.setPreferredSize(new Dimension(wid/2 - wid*5/100, max));
        princ_act.setAutoscrolls(true);

        exci.setBackground(Color.WHITE);
        //exci.setBounds(0, hei*28/100, wid/2 - wid*5/100, test3);
        exci.setPreferredSize(new Dimension(wid/2 - wid*5/100, max));
        exci.setAutoscrolls(true);

        condi.setBackground(Color.WHITE);
        //condi.setBounds(0, (hei*28/100)*2, wid/2 - wid*5/100, test3);
        condi.setPreferredSize(new Dimension(wid/2 - wid*5/100, max));
        condi.setAutoscrolls(true);

        mat.setBackground(Color.WHITE);
        mat.setLayout(new BoxLayout(mat, BoxLayout.PAGE_AXIS));
        mat.setPreferredSize(new Dimension(wid/2 - wid*5/100, 5000));
        mat.setAutoscrolls(true);

        
        JScrollPane scrollPane = new JScrollPane(princ_act);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, hei*9/100, wid/2, hei*28/100);
        
        JScrollPane scrollPane2 = new JScrollPane(exci);
        scrollPane2.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(0, hei*37/100, wid/2, hei*28/100);
        
        JScrollPane scrollPane3 = new JScrollPane(condi);
        scrollPane3.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane3.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane3.setBounds(0, hei*65/100, wid/2, hei*28/100);
        
        JScrollPane scrollPane4 = new JScrollPane(mat);
        scrollPane4.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane4.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane4.setBounds((int) (wid/2 + wid*0.5/100), hei*15/100, wid/2 - wid*2/100, hei*60/100); 

        //this.setPreferredSize(new Dimension(1000, 200));
        
        princ_act.setLayout(new GridBagLayout());
        exci.setLayout(new GridBagLayout());
        condi.setLayout(new GridBagLayout());
        mat.setLayout(new GridBagLayout());

        formule.add(scrollPane, new GridBagLayout());     
        formule.add(scrollPane2, new GridBagLayout());
        formule.add(scrollPane3, new GridBagLayout());
        this.add(scrollPane4, new GridBagLayout());
        
        GridBagConstraints grid_princ_act = new GridBagConstraints();
        GridBagConstraints grid_exci = new GridBagConstraints();
        GridBagConstraints grid_condi = new GridBagConstraints();
        GridBagConstraints grid_mat = new GridBagConstraints();
        
        grid_princ_act.weighty = 1;

        int i = 0;
        
        quant = new JLabel();
        quant.setText("Principe actif");
        quant.setOpaque(true);
        quant.setHorizontalAlignment(SwingConstants.CENTER); 
        quant.setFont(new Font("Arial", Font.BOLD, 17));
        quant.setBackground(new java.awt.Color(0,156,218));
        quant.setForeground(Color.WHITE);
        quant.setPreferredSize(new Dimension(150, 30));
        grid_princ_act.gridx = 0;
        grid_princ_act.gridy = 0;
        princ_act.add(quant, grid_princ_act);
               
        for (i = 1; i <= var1; i++) {
             
            quant = new JLabel ();
            name = new JLabel ("GENTAMICINE 80mg - 2ml");
            scan_1 = new JLabel ("SCAN");
            scan_2 = new JLabel ("SCAN");

            grid_princ_act.weightx = 0;
    
            quant.setText("" + i);
            quant.setOpaque(true);
            quant.setHorizontalAlignment(SwingConstants.CENTER); 
            quant.setFont(new Font("Arial", Font.BOLD, 17));
            quant.setBackground(new java.awt.Color(0,156,218));
            quant.setForeground(Color.WHITE);
            quant.setPreferredSize(new Dimension(40, 30));
            quant.setBorder(new LineBorder(Color.BLUE));
            grid_princ_act.gridx = 1;
            grid_princ_act.gridy = i;
            princ_act.add(quant, grid_princ_act);
                        
            name.setText("GENTAMICINE 80mg - 2ml");
            name.setOpaque(true);
            name.setHorizontalAlignment(SwingConstants.CENTER); 
            name.setFont(new Font("Arial", Font.PLAIN, 17));
            name.setBackground(new java.awt.Color(0,156,218));
            name.setForeground(Color.WHITE);
            name.setPreferredSize(new Dimension(300, 30));
            name.setBorder(new LineBorder(Color.BLUE));
            grid_princ_act.gridx = 2;
            grid_princ_act.gridy = i;
            princ_act.add(name, grid_princ_act);
         
            scan_1.setText("SCAN");
            scan_1.setOpaque(true);
            scan_1.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_1.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_1.setBackground(Color.WHITE);
            scan_1.setForeground(new java.awt.Color(0,156,218));
            scan_1.setPreferredSize(new Dimension(200, 30));
            scan_1.setBorder(new LineBorder(Color.BLUE));
            grid_princ_act.gridx = 3;
            grid_princ_act.gridy = i;
            princ_act.add(scan_1, grid_princ_act);
            
            grid_princ_act.fill = GridBagConstraints.HORIZONTAL;
            
            scan_2.setText("SCAN");
            scan_2.setOpaque(true);
            scan_2.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_2.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_2.setBackground(Color.WHITE);
            scan_2.setForeground(new java.awt.Color(0,156,218));
            scan_2.setPreferredSize(new Dimension(150, 30));
            scan_2.setBorder(new LineBorder(Color.BLUE));
            grid_princ_act.gridx = 4;
            grid_princ_act.gridy = i;
            princ_act.add(scan_2, grid_princ_act);
            

                 if (test1 != max & i == var1){
                     System.out.println("aaa");
                    for (int j = var1; j*40+40 < max; j++){
                        quant = new JLabel();
                        quant.setPreferredSize(new Dimension(40, 30));
                        grid_princ_act.gridx = 0;
                        grid_princ_act.gridy = j;
                        princ_act.add(quant, grid_princ_act);
                    }
                 }
        
        }
        grid_exci.weighty = 1;
        
        quant = new JLabel();
        quant.setText("Excipient");
        quant.setOpaque(true);
        quant.setHorizontalAlignment(SwingConstants.CENTER); 
        quant.setFont(new Font("Arial", Font.BOLD, 17));
        quant.setBackground(new java.awt.Color(0,156,218));
        quant.setForeground(Color.WHITE);
        quant.setPreferredSize(new Dimension(150, 30));
        grid_exci.gridx = 0;
        grid_exci.gridy = 0;
        exci.add(quant, grid_exci);
        
      

        for (i = 1; i <= var2; i++) {
             
            quant = new JLabel ();
            name = new JLabel ("GENTAMICINE 80mg - 2ml");
            scan_1 = new JLabel ("SCAN");
            scan_2 = new JLabel ("SCAN");

            grid_exci.weightx = 0;
    
            quant.setText("" + i);
            quant.setOpaque(true);
            quant.setHorizontalAlignment(SwingConstants.CENTER); 
            quant.setFont(new Font("Arial", Font.BOLD, 17));
            quant.setBackground(new java.awt.Color(0,156,218));
            quant.setForeground(Color.WHITE);
            quant.setPreferredSize(new Dimension(40, 30));
            quant.setBorder(new LineBorder(Color.BLUE));
            grid_exci.gridx = 1;
            grid_exci.gridy = i;
            exci.add(quant, grid_exci);

            name.setText("GENTAMICINE 80mg - 2ml");
            name.setOpaque(true);
            name.setHorizontalAlignment(SwingConstants.CENTER); 
            name.setFont(new Font("Arial", Font.PLAIN, 17));
            name.setBackground(new java.awt.Color(0,156,218));
            name.setForeground(Color.WHITE);
            name.setPreferredSize(new Dimension(300, 30));
            name.setBorder(new LineBorder(Color.BLUE));
            grid_exci.gridx = 2;
            grid_exci.gridy = i;
            exci.add(name, grid_exci);
         
            scan_1.setText("SCAN");
            scan_1.setOpaque(true);
            scan_1.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_1.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_1.setBackground(Color.WHITE);
            scan_1.setForeground(new java.awt.Color(0,156,218));
            scan_1.setPreferredSize(new Dimension(200, 30));
            scan_1.setBorder(new LineBorder(Color.BLUE));
            grid_exci.gridx = 3;
            grid_exci.gridy = i;
            exci.add(scan_1, grid_exci);
            
            grid_exci.fill = GridBagConstraints.HORIZONTAL;
            
            scan_2.setText("SCAN");
            scan_2.setOpaque(true);
            scan_2.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_2.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_2.setBackground(Color.WHITE);
            scan_2.setForeground(new java.awt.Color(0,156,218));
            scan_2.setPreferredSize(new Dimension(150, 30));
            scan_2.setBorder(new LineBorder(Color.BLUE));
            grid_exci.gridx = 4;
            grid_exci.gridy = i;
            exci.add(scan_2, grid_exci);
            
           
                 if (test2 != max & i == var2){ 
                     System.out.println("YES");
                    for (int j = var2; j*40+40 < max; j++){
                        quant = new JLabel();
                        quant.setPreferredSize(new Dimension(40, 30));
                        grid_exci.gridx = 0;
                        grid_exci.gridy = j;
                        exci.add(quant, grid_exci);
                    }
                 }
 
        }
        
        grid_condi.weighty = 1;
       
        quant = new JLabel();
        quant.setText("Conditionnement");
        quant.setOpaque(true);
        quant.setHorizontalAlignment(SwingConstants.CENTER); 
        quant.setFont(new Font("Arial", Font.BOLD, 17));
        quant.setBackground(new java.awt.Color(0,156,218));
        quant.setForeground(Color.WHITE);
        quant.setPreferredSize(new Dimension(150, 30));
        grid_condi.gridx = 0;
        grid_condi.gridy = 0;
        condi.add(quant, grid_condi);
        

        for (i = 1; i <= var3; i++) {
             
            quant = new JLabel ();
            name = new JLabel ("GENTAMICINE 80mg - 2ml");
            scan_1 = new JLabel ("SCAN");
            scan_2 = new JLabel ("SCAN");

            grid_condi.weightx = 0;
    
            quant.setText("" + i);
            quant.setOpaque(true);
            quant.setHorizontalAlignment(SwingConstants.CENTER); 
            quant.setFont(new Font("Arial", Font.BOLD, 17));
            quant.setBackground(new java.awt.Color(0,156,218));
            quant.setForeground(Color.WHITE);
            quant.setPreferredSize(new Dimension(40, 30));
            quant.setBorder(new LineBorder(Color.BLUE));
            grid_condi.gridx = 1;
            grid_condi.gridy = i;
            condi.add(quant, grid_condi);

            name.setText("GENTAMICINE 80mg - 2ml");
            name.setOpaque(true);
            name.setHorizontalAlignment(SwingConstants.CENTER); 
            name.setFont(new Font("Arial", Font.PLAIN, 17));
            name.setBackground(new java.awt.Color(0,156,218));
            name.setForeground(Color.WHITE);
            name.setPreferredSize(new Dimension(300, 30));
            name.setBorder(new LineBorder(Color.BLUE));
            grid_condi.gridx = 2;
            grid_condi.gridy = i;
            condi.add(name, grid_condi);
         
            scan_1.setText("SCAN");
            scan_1.setOpaque(true);
            scan_1.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_1.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_1.setBackground(Color.WHITE);
            scan_1.setForeground(new java.awt.Color(0,156,218));
            scan_1.setPreferredSize(new Dimension(200, 30));
            scan_1.setBorder(new LineBorder(Color.BLUE));
            grid_condi.gridx = 3;
            grid_condi.gridy = i;
            condi.add(scan_1, grid_condi);
            
            grid_condi.fill = GridBagConstraints.HORIZONTAL;
            
            scan_2.setText("SCAN");
            scan_2.setOpaque(true);
            scan_2.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_2.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_2.setBackground(Color.WHITE);
            scan_2.setForeground(new java.awt.Color(0,156,218));
            scan_2.setPreferredSize(new Dimension(150, 30));
            scan_2.setBorder(new LineBorder(Color.BLUE));
            grid_condi.gridx = 4;
            grid_condi.gridy = i;
            condi.add(scan_2, grid_condi);
            

                 if (test3 == max & i > var3){
                    for (var3 = var3; var3*40+40 < max; var3++){
                        quant = new JLabel();
                        quant.setPreferredSize(new Dimension(40, 30));
                        grid_condi.gridx = 0;
                        grid_condi.gridy = var3;
                        condi.add(quant, grid_condi);
                    }
                 }
 
        }
        
        grid_mat.weighty = 1;
        
        for (i= 0; i < 100; i++) {
             
            quant = new JLabel ();
            name = new JLabel ("GENTAMICINE 80mg - 2ml");
            scan_1 = new JLabel ("SCAN");
            scan_2 = new JLabel ("SCAN");

            grid_mat.weightx = 0;
    
            quant.setText("" + i);
            quant.setOpaque(true);
            quant.setHorizontalAlignment(SwingConstants.CENTER); 
            quant.setFont(new Font("Arial", Font.BOLD, 17));
            quant.setBackground(new java.awt.Color(0,156,218));
            quant.setForeground(Color.WHITE);
            quant.setPreferredSize(new Dimension(40, 30));
            quant.setBorder(new LineBorder(Color.BLUE));
            grid_mat.gridx = 0;
            grid_mat.gridy = i;
            mat.add(quant, grid_mat);

            name.setText("GENTAMICINE 80mg - 2ml");
            name.setOpaque(true);
            name.setHorizontalAlignment(SwingConstants.CENTER); 
            name.setFont(new Font("Arial", Font.PLAIN, 17));
            name.setBackground(new java.awt.Color(0,156,218));
            name.setForeground(Color.WHITE);
            name.setPreferredSize(new Dimension(300, 30));
            name.setBorder(new LineBorder(Color.BLUE));
            grid_mat.gridx = 1;
            grid_mat.gridy = i;
            mat.add(name, grid_mat);
         
            scan_1.setText("SCAN");
            scan_1.setOpaque(true);
            scan_1.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_1.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_1.setBackground(Color.WHITE);
            scan_1.setForeground(new java.awt.Color(0,156,218));
            scan_1.setPreferredSize(new Dimension(200, 30));
            scan_1.setBorder(new LineBorder(Color.BLUE));
            grid_mat.gridx = 2;
            grid_mat.gridy = i;
            mat.add(scan_1, grid_mat);
            
            grid_mat.fill = GridBagConstraints.HORIZONTAL;
            
            scan_2.setOpaque(true);
            scan_2.setText("SCAN");
            scan_2.setHorizontalAlignment(SwingConstants.CENTER); 
            scan_2.setFont(new Font("Arial", Font.PLAIN, 17));
            scan_2.setBackground(Color.WHITE);
            scan_2.setForeground(new java.awt.Color(0,156,218));
            scan_2.setPreferredSize(new Dimension(150, 30));
            scan_2.setBorder(new LineBorder(Color.BLUE));
            grid_mat.gridx = 3;
            grid_mat.gridy = i;
            mat.add(scan_2, grid_mat);
 
        }
        
        this.setLayout(null);
    }

}
