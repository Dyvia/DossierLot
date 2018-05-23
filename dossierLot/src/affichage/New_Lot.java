/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affichage;

import com.barcodelib.barcode.DataMatrix;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

/**
 *
 * @author Kenny
 */
public class New_Lot extends JPanel{
    
    JButton b_new_lot, b_retour;
    JTextField qt;
    JComboBox list_med;
    JLabel num_lot, num;
    int wid, hei;

    public New_Lot(ArrayList<String> medicaments, int wi, int he) {
        
       
        
        b_new_lot = new JButton("<html><font size=10 style='Arial' color='white'>Nouveau lot</font></html>");
        b_retour = new JButton("<html><font size=15 style='Arial' color='white'>R</font></html>");
        qt = new JTextField("20");
        list_med=new JComboBox(medicaments.toArray());
        num_lot = new JLabel("<html><font size=10 style='Arial'>n° de lot :</font></html>");
        num = new JLabel("<html><b></b></html>");
        
        wid = wi;
        hei = he;
        initialisation();
    }
    
    private void initialisation(){
        
        b_new_lot.setBounds(wid*42/100, hei*28/100, wid*16/100, hei*7/100);
        //b_new_lot.setBounds(800, 300, 300, 100);
        b_new_lot.setBackground(new java.awt.Color(0,156,218));
        this.add(b_new_lot);
        
        b_retour.setBounds(wid*5/100, hei*85/100, wid*4/100, hei*6/100);
        b_retour.setBackground(new java.awt.Color(0,156,218));
        this.add(b_retour);
        
        qt.setBounds(wid*55/100, hei*14/100, wid*5/100, hei*5/100);
        this.add(qt);
        
        num_lot.setBounds(wid*21/100, hei*58/100, wid*11/100, hei*7/100);
        this.add(num_lot);
        
        num.setBounds(wid*31/100, hei*47/100, wid*37/100, hei*28/100);
        num.setOpaque(true);
        num.setFont(new Font("Arial", Font.PLAIN, 30));
        num.setHorizontalAlignment( SwingConstants.CENTER);
        num.setForeground(Color.white);
        num.setBackground(new java.awt.Color(0,156,218));
        this.add(num);

        
        list_med.setVisible(true);

        
        int horizontal=500;
        int vertical=155;
        list_med.setBackground( Color.white);
        list_med.setForeground(new Color(0, 156, 218));
        list_med.setBounds(wid*26/100, hei*14/100, wid*25/100, hei*5/100);
        this.add(list_med);

        
        
        this.setLayout(null);
    }

    String getItemSelect() {
        return list_med.getSelectedItem().toString(); 
    }

    void creerLot(String cheminLots,String cheminPDF) throws IOException, Exception {
        
        
        System.out.println("creerlot");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date aujourdhui=new Date();
        char lettre='A';
        File f=new File(cheminLots+dateFormat.format(aujourdhui)+lettre);
        while(f.exists()){
            lettre++;
            f = new File (cheminLots+dateFormat.format(aujourdhui)+lettre);
        }
        f.mkdir();
        String numLot=dateFormat.format(aujourdhui)+lettre;
        
        File file=new File("C://Users//dyvia//OneDrive//Bureau//Stage//Projets//Gestion_de_lots_dématérialisée//netbeans//FILE TEST ZONE//doc.pdf");
        PDDocument doc = new PDDocument().load(file);
        PDDocumentCatalog docCatalog = doc.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        PDField field = acroForm.getField("nom");
        field.setValue(list_med.getSelectedItem().toString());
        doc.save(f+"//fiche.pdf");
        doc.close();
        
        DataMatrix barcode = new DataMatrix(); 
        barcode.setData("~"+numLot+"#");
 

        barcode.renderBarcode("C://Users//dyvia//OneDrive//Bureau//Stage//Projets//Gestion_de_lots_dématérialisée//netbeans//FILE TEST ZONE//"+numLot+".gif");
       
        
        file=new File("C://Users//dyvia//OneDrive//Bureau//Stage//Projets//Gestion_de_lots_dématérialisée//netbeans//FILE TEST ZONE//doc.pdf");
        doc = new PDDocument().load(file);
        PDPage page = doc.getPage(0);
        PDImageXObject pdImage = PDImageXObject.createFromFile("C://Users//dyvia//OneDrive//Bureau//Stage//Projets//Gestion_de_lots_dématérialisée//netbeans//FILE TEST ZONE//"+numLot+".gif",doc);
        PDPageContentStream contents = new PDPageContentStream(doc, page);
        //Drawing the image in the PDF document
        contents.drawImage(pdImage, 70, 250);

        System.out.println("Image inserted");

        //Closing the PDPageContentStream object
        contents.close();
        
        doc.save("C://Users//dyvia//OneDrive//Bureau//Stage//Projets//Gestion_de_lots_dématérialisée//netbeans//FILE TEST ZONE//"+numLot+"//etiquette.pdf");
        doc.close();
        
        num.setText("<html><b>"+numLot+"</b></html>");
        
        
        this.repaint();
    }
}
