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
        area.setBounds(150, 150, 200, 200);
        
        pane = new JLayeredPane();
        pane.setPreferredSize(new Dimension(100, 100));
        pane.setBackground(new Color(0x4683b7));
        pane.setOpaque(true);
        pane.add(area);

        this.setTitle("Special Vending Machine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.add(spPanel);
        this.pack();
    }
}
