import javax.swing.*;

public class SpecialVMView extends JFrame {
    
    SpecialVMPanel spPanel;

    public SpecialVMView(){

        spPanel = new SpecialVMPanel();

        ImageIcon logo = new ImageIcon("logo.png");

        this.setTitle("Special Vending Machine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.add(spPanel);
        this.pack();
    }
}
