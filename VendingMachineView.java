import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VendingMachineView extends JFrame implements ActionListener{
    private final JButton enterBtn;
    private final JButton rvmBtn;
    private final JButton spvmBtn;
    private final JLabel text;
    private final JTextArea msgDisplay;
    
    public VendingMachineView(){

        ImageIcon logo = new ImageIcon("logo.png");
        
        JLabel title = new JLabel("Vending Machine Factory");
        title.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
        title.setBounds(145, 80, 500, 100);
        

        text = new JLabel("What kind of Vending Machine would you like to make?");
        text.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
        text.setBounds(30, 100, 450, 100);

        enterBtn = new JButton("Enter");
        enterBtn.setBounds(400,500,75,30);
        enterBtn.setFocusable(false);
        enterBtn.addActionListener(this);
        enterBtn.setVisible(false);

        rvmBtn = new JButton("Regular");
        rvmBtn.setBounds(150, 200, 200, 50);
        rvmBtn.setFocusable(false);
        rvmBtn.addActionListener(this);
        rvmBtn.setBorder(BorderFactory.createEtchedBorder());

        spvmBtn = new JButton("Special");
        spvmBtn.setBounds(150, 275, 200, 50);
        spvmBtn.setFocusable(false);
        spvmBtn.addActionListener(this);
        rvmBtn.setBorder(BorderFactory.createEtchedBorder());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(300,100));

        this.msgDisplay = new JTextArea("");
        this.msgDisplay.setPreferredSize(new Dimension(200, 100));
        this.msgDisplay.setEditable(false);
        
        this.setTitle("Vending Machine Factory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setLayout(null);
        this.setSize(500, 650);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x3466A5)); //set background color
        this.setIconImage(logo.getImage());
        this.add(title);
        this.add(text);
        this.add(enterBtn);
        this.add(rvmBtn);
        this.add(spvmBtn);
        this.add(msgDisplay);
        this.setVisible(true); //make frame visible
        //this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==enterBtn){
            enterBtn.setEnabled(false);
            System.out.println("Enter was clicked");
        }else if(e.getSource()==rvmBtn){
            rvmBtn.setEnabled(false);
            enterBtn.setVisible(true);
            rvmBtn.setVisible(false);
            spvmBtn.setVisible(false);
            text.setVisible(false);
            System.out.println("Creating Regular Vending Machine...");
            System.out.println("Regular Vending Machine created");
            System.out.println("Congratulations! You have created a regular vending machine");
            System.out.println("Welcome to the Regular Vending Machine");
        }else if (e.getSource()==spvmBtn){
            spvmBtn.setEnabled(false);
            enterBtn.setVisible(true);
            rvmBtn.setVisible(false);
            spvmBtn.setVisible(false);
            text.setVisible(false);
            System.out.println("Creating Special Vending Machine...");
            System.out.println("Special Vending Machine created");
            System.out.println("Congratulations! You have created a special vending machine");
            System.out.println("Welcome to the Special Vending Machine");
        }
    }

 
}
