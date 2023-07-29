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
    RegularVMModel rVmModel;

    public RegularVMPanel(){

        rVmModel = new RegularVMModel();
        rVmModel.populateItems();
        rVmModel.populateRegister();

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
        g2D.drawString(rVmModel.getItems().get(0).getName(), 60, 175);
        g2D.drawString(rVmModel.getItems().get(1).getName(), 155, 175);
        g2D.drawString(rVmModel.getItems().get(2).getName(), 270, 175);
        g2D.drawString(rVmModel.getItems().get(3).getName(), 410, 175);
        g2D.drawString(rVmModel.getItems().get(4).getName(), 530, 175);
        g2D.drawString(rVmModel.getItems().get(5).getName(), 55, 354);
        g2D.drawString(rVmModel.getItems().get(6).getName(), 160, 354);
        g2D.drawString(rVmModel.getItems().get(7).getName(), 270, 354);
        g2D.drawString(rVmModel.getItems().get(8).getName(), 405, 354);
        g2D.drawString(rVmModel.getItems().get(9).getName(), 520, 354);
        //Product prices
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(0).getPrice()), 60, 190);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(1).getPrice()), 170, 190);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(2).getPrice()), 288, 190);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(3).getPrice()), 405, 190);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(4).getPrice()), 532, 190);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(5).getPrice()), 60, 370);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(6).getPrice()), 165, 370);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(7).getPrice()), 290, 370);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(8).getPrice()), 410, 370);
        g2D.drawString(String.format("%.2f", rVmModel.getItems().get(9).getPrice()), 530, 370);
    }

}
