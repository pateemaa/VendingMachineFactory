import javax.swing.*;
import java.awt.*;

public class RegularVMPanel extends JPanel{
    
    Image rum;
    Image limeJ;
    Image sodaW;
    Image gin;
    Image tonic;
    Image tequila;
    Image whiskey;
    Image orangeJ;
    Image vodka;
    Image vermouth;

    public RegularVMPanel(){

        rum = new ImageIcon("rum.png").getImage();
        limeJ = new ImageIcon("limej.png").getImage();
        sodaW = new ImageIcon("sodaW.png").getImage();
        gin = new ImageIcon("gin.png").getImage();
        tonic = new ImageIcon("tonic.png").getImage();
        tequila = new ImageIcon("tequila.png").getImage();
        whiskey = new ImageIcon("whiskey.png").getImage();
        orangeJ = new ImageIcon("oj.png").getImage();
        vodka = new ImageIcon("vodka.png").getImage();
        vermouth = new ImageIcon("vermouth.png").getImage();

        this.setPreferredSize(new Dimension(615, 620));
        this.setBackground(new Color(0x4683b7));
       
    } 
    
    public void paintComponent(Graphics g){

        Item drinkName;

        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        
        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawRect(15, 15, 575, 375);
        
        g2D.setPaint(new Color(0x89CFF0));
        g2D.drawRect(18, 18, 569, 369);
        g2D.fillRect(18, 18, 569, 369);

        g2D.setPaint(new Color(0xB5E2FF));
        g2D.drawRect(18, 160, 569, 30);
        g2D.fillRect(18, 160, 569, 30);

        g2D.setPaint(new Color(0xB5E2FF));
        g2D.drawRect(18, 340, 569, 30);
        g2D.fillRect(18, 340, 569, 30);

        g2D.drawImage(rum, 20, 23, null);
        g2D.drawImage(limeJ, 120, 50, null);
        g2D.drawImage(sodaW, 280, 20, null);
        g2D.drawImage(gin, 390, 25, null);
        g2D.drawImage(tonic, 475, 20, null);
        g2D.drawImage(tequila, 5, 210, null);
        g2D.drawImage(whiskey, 120, 205, null);
        g2D.drawImage(orangeJ, 280, 200, null);
        g2D.drawImage(vodka, 400, 200, null);
        g2D.drawImage(vermouth, 475, 205, null);
        
        g2D.setPaint(Color.BLACK);
        //Product name
        g2D.drawString("Rum", 60, 175);
        g2D.drawString("Rum", 175, 175);
        g2D.drawString("Rum", 290, 175);
        g2D.drawString("Rum", 410, 175);
        g2D.drawString("Rum", 530, 175);
        g2D.drawString("Rum", 60, 354);
        g2D.drawString("Rum", 175, 354);
        g2D.drawString("Rum", 290, 354);
        g2D.drawString("Rum", 410, 354);
        g2D.drawString("Rum", 530, 354);
        //Product prices
        g2D.drawString("20.00", 60, 190);
        g2D.drawString("Rum", 175, 190);
        g2D.drawString("Rum", 290, 190);
        g2D.drawString("Rum", 410, 190);
        g2D.drawString("Rum", 530, 190);
        g2D.drawString("Rum", 60, 370);
        g2D.drawString("Rum", 175, 370);
        g2D.drawString("Rum", 290, 370);
        g2D.drawString("Rum", 410, 370);
        g2D.drawString("Rum", 530, 370);
    }

}
