import javax.swing.*;
import java.awt.*;

/**
 * This class contains the panel for the regular vending machine's view. It displays the images and
 *  information of the items available in the vending machine.
 */
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

    /**
     * Creates an instance of the RegularVMPanel
     */
    public RegularVMPanel(){

        rVmModel = new RegularVMModel();
        rVmModel.initializeInventory();
        rVmModel.initializeRegister();

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
    
    /**
     * Paints the component by drawing the vending machine frame, images of items, and their information.
     * @param g is the Graphics object used for painting.
     */
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
        g2D.drawString(rVmModel.getItems().get(0).getName() + " (Cal: " + rVmModel.getItems().get(0).getCalories() + ")", 40, 175);
        g2D.drawString(rVmModel.getItems().get(1).getName() + " (Cal: " + rVmModel.getItems().get(1).getCalories() + ")", 140, 175);
        g2D.drawString(rVmModel.getItems().get(2).getName() + " (Cal: " + rVmModel.getItems().get(2).getCalories() + ")", 260, 175);
        g2D.drawString(rVmModel.getItems().get(3).getName() + " (Cal: " + rVmModel.getItems().get(3).getCalories() + ")", 390, 175);
        g2D.drawString(rVmModel.getItems().get(4).getName() + " (Cal: " + rVmModel.getItems().get(4).getCalories() + ")", 505, 175);
        g2D.drawString(rVmModel.getItems().get(5).getName() + " (Cal: " + rVmModel.getItems().get(5).getCalories() + ")", 30, 354);
        g2D.drawString(rVmModel.getItems().get(6).getName() + " (Cal: " + rVmModel.getItems().get(6).getCalories() + ")", 145, 354);
        g2D.drawString(rVmModel.getItems().get(7).getName() + " (Cal: " + rVmModel.getItems().get(7).getCalories() + ")", 255, 354);
        g2D.drawString(rVmModel.getItems().get(8).getName() + " (Cal: " + rVmModel.getItems().get(8).getCalories() + ")", 390, 354);
        g2D.drawString(rVmModel.getItems().get(9).getName() + " (Cal: " + rVmModel.getItems().get(9).getCalories() + ")", 485, 354);
        //Product prices
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(0).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(0))), 40, 190);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(1).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(1))), 150, 190);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(2).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(2))), 270, 190);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(3).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(3))), 390, 190);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(4).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(4))), 505, 190);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(5).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(5))), 40, 370);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(6).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(6))), 150, 370);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(7).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(7))), 270, 370);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(8).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(8))), 390, 370);
        g2D.drawString(String.format("%.2f (Qty: %d)", rVmModel.getItems().get(9).getPrice(), rVmModel.returnItemQty(rVmModel.getItems().get(9))), 505, 370);
    }

    /**
     * Updates the display by repainting the panel.
     */
    public void updateDisplay(){
        repaint();
    }

}
