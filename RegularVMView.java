import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegularVMView extends JFrame{
    
    RegularVMPanel rvmPanel;
    RegularVMModel rvmModel;
    private JLabel item;
    private JLabel payment;
    private JLayeredPane layer;
    private JComboBox<Item> itemList;
    private JComboBox<Denomination> denominationList;
    private JSlider cashSlider;
    private JButton addBtn;
    private JButton payBtn;
    private JTextArea display;
    private JMenuBar menu;
    private JMenu maintenance;
    private JMenuItem restock;
    private JMenuItem replenish;
    private JMenuItem updatePrice;
    private JMenuItem collect;

    public RegularVMView(){

        rvmPanel = new RegularVMPanel();
        rvmModel = new RegularVMModel();

        rvmModel.populateItems();
        rvmModel.populateRegister();
        
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
        itemList = new JComboBox<>(rvmModel.getItems().toArray(new Item[0]));
        itemList.setBounds(60, 10, 110, 30);

        denominationList = new JComboBox<>(rvmModel.getCashRegister().toArray(new Denomination[0]));
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

        payBtn = new JButton("Pay");
        payBtn.setFocusable(false);
        payBtn.setBounds(110, 170, 60, 30);

        //JTextArea
        display = new JTextArea(" ");
        display.setBounds(225, 10, 360, 200);
        display.setEditable(false);

        //JMenuItem
        restock = new JMenuItem("Restock Items");
        replenish = new JMenuItem("Replenish Register");
        updatePrice = new JMenuItem("Update Item Price");
        collect = new JMenuItem("Collect Cash");

        restock.setFont(new Font("Calibri", Font.PLAIN, 15));
        replenish.setFont(new Font("Calibri", Font.PLAIN, 15));
        updatePrice.setFont(new Font("Calibri", Font.PLAIN, 15));
        collect.setFont(new Font("Calibri", Font.PLAIN, 15));

        //JMenu
        maintenance = new JMenu("Maintenance");
        maintenance.add(restock);
        maintenance.add(replenish);
        maintenance.add(updatePrice);
        maintenance.add(collect);

        //JMenuBar
        menu = new JMenuBar();
        menu.add(maintenance);
        
        //JLayeredPane
        layer = new JLayeredPane();
        layer.setPreferredSize(new Dimension(200, 280));
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
        this.setJMenuBar(menu);
        this.add(rvmPanel);
        this.add(layer, BorderLayout.SOUTH);
        this.pack();
    
    }

    public double getDenomListSelectedItem(){
        Denomination denom_selected = (Denomination) denominationList.getSelectedItem();
        
        return denom_selected.getDenomination();
    }

    public int getCashSliderValue(){
            int nCashQty;

            nCashQty = cashSlider.getValue();

            return nCashQty;
    }

    public int getPaymentTotal(){
        int cashQty, denomType, total = 0;

        cashQty = (int) cashSlider.getValue();
        denomType = (int) getDenomListSelectedItem();

        total += cashQty*denomType;
        
        return total;
    }

    public void setAddBtnActionListener(ActionListener action){
        addBtn.addActionListener(action);
    }

    public void setPayBtnActionListener(ActionListener action){
        payBtn.addActionListener(action);
    }

    public void setItemListActionListener(ActionListener action){
        itemList.addActionListener(action);
    }

    public void setDenomListActionListener(ActionListener action){
        denominationList.addActionListener(action);
    }

     public void setRestonkActionListener(ActionListener action){
        restock.addActionListener(action);
    }

    public void setReplenishActionListener(ActionListener action){
        replenish.addActionListener(action);
    }

    public void setUpdatePriceActionListener(ActionListener action){
        updatePrice.addActionListener(action);
    }
    
    public void setCollectActionListener(ActionListener action){
        collect.addActionListener(action);
    }

    public void setDisplayTextArea(String feedback){
        display.setText(feedback);
    }
}
