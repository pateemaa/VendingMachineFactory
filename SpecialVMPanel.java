import javax.swing.*;
import java.awt.*;

public class SpecialVMPanel extends JPanel{
    
    Image rum;
    Image limeJ;
    Image sodaW;
    Image gin;
    Image tonic;
    Image tequilla;
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
        tequilla = new ImageIcon("tequilla.png").getImage();
        whiskey = new ImageIcon("whiskey.png").getImage();
        orangeJ = new ImageIcon("oj.png").getImage();
        vodka = new ImageIcon("vodka.png").getImage();
        vermouth = new ImageIcon("vermouth.png").getImage();
        this.setPreferredSize(new Dimension(615, 620));
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawRect(15, 15, 575, 375);
        g2D.drawImage(rum, 20, 20, null);
        g2D.drawImage(limeJ, 120, 50, null);
        g2D.drawImage(sodaW, 280, 20, null);
        g2D.drawImage(gin, 300, 20, null);
        g2D.drawImage(tonic, 475, 20, null);
        g2D.drawImage(tequilla, 20, 200, null);
        g2D.drawImage(whiskey, 120, 200, null);
        g2D.drawImage(orangeJ, 280, 200, null);
        g2D.drawImage(vodka, 300, 200, null);
        g2D.drawImage(vermouth, 500, 200, null);
    }
}
