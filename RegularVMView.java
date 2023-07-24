import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RegularVMView extends JFrame implements ActionListener{
    
    RegularVMPanel rvmPanel;
    private JLabel item;
    private JLabel payment;
    private JLayeredPane layer;
    private JComboBox<Item> itemList;
    private JComboBox<Denomination> denominationList;
    private ArrayList<Item> drinks;
    private ArrayList<Denomination> cash;

    public RegularVMView(){

        drinks = new ArrayList<>();
        drinks.add(new Item("Rum", 1.50));
        drinks.add(new Item("Vodka", 1.25));
        drinks.add(new Item("Tequila", 1.30));

        cash = new ArrayList<>();
        cash.add(new Denomination(100.00));
        cash.add(new Denomination(50.00));
        cash.add(new Denomination(20.00));

        rvmPanel = new RegularVMPanel();
        
        ImageIcon logo = new ImageIcon("logo.png");

        item = new JLabel("Item:");
        item.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        item.setBounds(10, 10, 50, 30);

        payment = new JLabel("Payment:");
        payment.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        payment.setBounds(10, 70, 80, 30);

        itemList = new JComboBox<>(drinks.toArray(new Item[0]));
        itemList.addActionListener(this);
        itemList.setBounds(50, 10, 70, 30);

        denominationList = new JComboBox<>(cash.toArray(new Denomination[0]));
        denominationList.addActionListener(this);
        denominationList.setBounds(80, 70, 80, 30);
        
        layer = new JLayeredPane();
        layer.setPreferredSize(new Dimension(250, 250));
        layer.setOpaque(true);
        layer.add(item, JLayeredPane.DRAG_LAYER);
        layer.add(payment, JLayeredPane.DRAG_LAYER);
        layer.add(itemList, JLayeredPane.DRAG_LAYER);
        layer.add(denominationList, JLayeredPane.DRAG_LAYER);
        
        this.setTitle("Regular Vending Machine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.add(rvmPanel);
        this.add(layer, BorderLayout.SOUTH);
        this.pack();
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == itemList){
            System.out.println(itemList.getSelectedItem());
        }
    }
    
}
