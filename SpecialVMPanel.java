import javax.swing.*;
import java.awt.*;

public class SpecialVMPanel extends JPanel{
    
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
    // Image mojito;
    // Image ginNtonic;
    // Image gimlet;
    // Image mint;
    // Image lime;
    // Image powderSugar;

    public SpecialVMPanel(){
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
        this.setPreferredSize(new Dimension(600, 620));
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(0xF4A460));
        g2D.setStroke(new BasicStroke(3));
        g2D.drawRoundRect(15, 15, 575, 375, 50, 50);
        g2D.fillRoundRect(15, 15, 574, 374, 50, 50);

        g2D.setPaint(new Color(0x62BD69));
        g2D.setStroke(new BasicStroke(3));
        g2D.drawRoundRect(15, 400, 280, 200, 50, 50);
        g2D.fillRoundRect(15, 400, 280, 200, 50, 50);

        g2D.setPaint(new Color(0xFDFC96));
        g2D.setStroke(new BasicStroke(3));
        g2D.drawRoundRect(305, 400, 280, 200, 50, 50);
        g2D.fillRoundRect(305, 400, 280, 200, 50, 50);
        
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
    }
}
