import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VendingMachineView extends JFrame{
    private final JButton rvmBtn;
    private final JButton spvmBtn;
    private final JLabel text;

    /**
     * Creates an instance of the vending machine's view
     */
    public VendingMachineView(){

        //ImageIcons
        ImageIcon logo = new ImageIcon("logo.png");

        //JLabels
        JLabel title = new JLabel("Welcome to the Vending Machine Factory!");
        title.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
        title.setBounds(65, 10, 500, 100);

        text = new JLabel("What kind of Vending Machine would you like to make?");
        text.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
        text.setBounds(32, 35, 450, 100);

        //JButtons
        rvmBtn = new JButton("Regular");
        rvmBtn.setBounds(150, 130, 200, 50);
        rvmBtn.setFocusable(false);
        rvmBtn.setBorder(BorderFactory.createEtchedBorder());

        spvmBtn = new JButton("Special");
        spvmBtn.setBounds(150, 190, 200, 50);
        spvmBtn.setFocusable(false);
        spvmBtn.setBorder(BorderFactory.createEtchedBorder());

        //frame
        this.setTitle("Vending Machine Factory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setLayout(null);
        this.setSize(500, 350);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x3466A5)); //set background color
        this.setIconImage(logo.getImage());
        this.add(title);
        this.add(text);
        this.add(rvmBtn);
        this.add(spvmBtn);
        this.setVisible(true); //make frame visible

    }
    
    /**
     * sets the action listener for the Regular button 
     * @param action is the action when Regular is clicked
     */
    public void setRvmBtnActionListener(ActionListener action) {
		rvmBtn.addActionListener(action);
	}

    /**
     * sets the action listener for the Special button 
     * @param action is the action when Special is clicked
     */
    public void setSpvmBtnActionListener(ActionListener action){
        spvmBtn.addActionListener(action);
    }
 
}
