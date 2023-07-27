import javax.swing.*;
import java.awt.*;

public class SpecialVMView extends JFrame {
    
    SpecialVMPanel spPanel;

    private JLayeredPane pane;
    private JTextArea area;

    public SpecialVMView(){

        spPanel = new SpecialVMPanel();

        ImageIcon logo = new ImageIcon("logo.png");
        
        area = new JTextArea(" ");
        area.setBounds(10, 10, 280, 290);
        
        pane = new JLayeredPane();
        pane.setPreferredSize(new Dimension(300, 100));
        pane.setBackground(new Color(0x4683b7));
        pane.setOpaque(true); 
        pane.add(area);

        this.setTitle("Special Vending Machine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.add(spPanel);
        this.add(pane, BorderLayout.EAST);
        this.pack();
    }
}
