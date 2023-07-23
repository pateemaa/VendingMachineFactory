import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VendingMachineView extends JFrame implements ActionListener{
    private final JButton rvmBtn;
    private final JButton spvmBtn;
    private final JLabel text;

    
    public VendingMachineView(){

        //ImageIcons
        ImageIcon logo = new ImageIcon("logo.png");

        //JLabels
        JLabel title = new JLabel("Vending Machine Factory");
        title.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
        title.setBounds(145, 80, 500, 100);

        text = new JLabel("What kind of Vending Machine would you like to make?");
        text.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
        text.setBounds(30, 100, 450, 100);

        //JButtons
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

        //frame
        this.setTitle("Vending Machine Factory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setLayout(null);
        this.setSize(500, 650);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x3466A5)); //set background color
        this.setIconImage(logo.getImage());
        this.add(title);
        this.add(text);
        this.add(rvmBtn);
        this.add(spvmBtn);
        this.setVisible(true); //make frame visible

    }
    
    public void setRvmBtnActionListener(ActionListener actionListener) {
		rvmBtn.addActionListener(actionListener);
	}

    public void setSpvmBtnActionListener(ActionListener actionListener){
        spvmBtn.addActionListener(actionListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rvmBtn){
            rvmBtn.setEnabled(false);
            rvmBtn.setVisible(false);
            spvmBtn.setVisible(false);
            text.setVisible(false);
        }else if (e.getSource()==spvmBtn){
            spvmBtn.setEnabled(false);
            rvmBtn.setVisible(false);
            spvmBtn.setVisible(false);
            text.setVisible(false);
        }
    }

 
}
