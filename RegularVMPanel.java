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

    private final JLabel item;

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

        item = new JLabel("Item:");
        
        this.setPreferredSize(new Dimension(615, 620));
        this.add(item);
    }    
    
    public void paint(Graphics g){
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

        item.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        item.setBounds(18, 200, 37, 50);
        
    }

}
