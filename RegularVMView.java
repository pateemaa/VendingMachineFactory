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
    private JSlider cashSlider;
    private JButton addBtn;
    private JButton payBtn;
    private JTextArea display;

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
        
        //ImageIcon
        ImageIcon logo = new ImageIcon("logo.png");

        //JLabel
        item = new JLabel("Item:");
        item.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        item.setBounds(20, 10, 50, 30);

        payment = new JLabel("Payment:");
        payment.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        payment.setBounds(20, 70, 80, 30);

        //JComboBox
        itemList = new JComboBox<>(drinks.toArray(new Item[0]));
        itemList.addActionListener(this);
        itemList.setBounds(60, 10, 70, 30);

        denominationList = new JComboBox<>(cash.toArray(new Denomination[0]));
        denominationList.addActionListener(this);
        denominationList.setBounds(85, 70, 80, 30);
        
        //JSlider
        cashSlider = new JSlider(0, 10, 5);
        cashSlider.setPreferredSize(new Dimension(150, 50));
        cashSlider.setBounds(20, 110, 150, 50);
        cashSlider.setPaintTicks(true);
        cashSlider.setMinorTickSpacing(1);
        cashSlider.setPaintTrack(true);
        cashSlider.setMajorTickSpacing(2);
        cashSlider.setPaintLabels(true);

        //JButton
        addBtn = new JButton("Add");
        addBtn.setFocusable(false);
        addBtn.setBounds(20, 170, 60, 30);
        addBtn.addActionListener(this);

        payBtn = new JButton("Pay");
        payBtn.setFocusable(false);
        payBtn.setBounds(110, 170, 60, 30);

        //JTextArea
        display = new JTextArea(" ");
        display.setBounds(225, 10, 360, 200);
        display.setEditable(false);

        //JLayeredPane
        layer = new JLayeredPane();
        layer.setPreferredSize(new Dimension(200, 300));
        layer.setBackground(new Color(0x4683b7));
        layer.setOpaque(true);
        layer.add(item, JLayeredPane.DRAG_LAYER);
        layer.add(payment, JLayeredPane.DRAG_LAYER);
        layer.add(itemList, JLayeredPane.DRAG_LAYER);
        layer.add(denominationList, JLayeredPane.DRAG_LAYER);
        layer.add(cashSlider, JLayeredPane.DRAG_LAYER);
        layer.add(addBtn, JLayeredPane.DRAG_LAYER);
        layer.add(payBtn, JLayeredPane.DRAG_LAYER);
        layer.add(display, JLayeredPane.DRAG_LAYER);
        

        //JFrame
        this.setTitle("Regular Vending Machine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.add(rvmPanel);
        this.add(layer, BorderLayout.SOUTH);
        this.pack();
    
    }

    public double getDenomListSelectedItem(){
        Denomination denom_selected = (Denomination) denominationList.getSelectedItem();
        
        return denom_selected.getDenomination();
    }

    public int getPaymentTotal(){
        int cashQty, denomType, total = 0;

        cashQty = (int) cashSlider.getValue();
        denomType = (int) getDenomListSelectedItem();

        total += cashQty*denomType;
        
        return total;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cashSlider){
            System.out.println(cashSlider.getValue());
        }else if(e.getSource() == addBtn){
            display.setText(cashSlider.getValue() + " " + getDenomListSelectedItem() + "\n" + "Total: " + getPaymentTotal());
        }
    }
    
}
