import javax.swing.*;
import java.awt.*;

public class VendingMachineView {
    private final JFrame frame;
    
    public VendingMachineView(){
        this.frame = new JFrame("Vending Machine Factory");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.frame.setSize(300, 100);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.frame.add(panel);
        panel.setPreferredSize(new Dimension(300,100));
    }
}
