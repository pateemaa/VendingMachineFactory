import javax.swing.*;

public class RegularVMView extends JFrame{
    
    RegularVMPanel rvmPanel;
    

    public RegularVMView(){

        rvmPanel = new RegularVMPanel();
        
        ImageIcon logo = new ImageIcon("logo.png");

        this.setTitle("Regular Vending Machine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.add(rvmPanel);
        this.pack();
    
    }
    
}
