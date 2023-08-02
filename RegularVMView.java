import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * This contains all the attributes and behaviors of the regular vending machine's view
 */
public class RegularVMView extends JFrame{
    
    RegularVMPanel rvmPanel;
    RegularVMModel rvmModel;
    RegularVMController rVmController;
    CashRegister reg;
    private JLabel item;
    private JLabel denomination;
    private JLabel priceLbl;
    private JLabel qtyLbl;
    private JLayeredPane layer;
    private JComboBox<Item> itemList;
    private JComboBox<Denomination> denominationList;
    private JSlider slider;
    private JButton addBtn;
    private JButton payBtn;
    private JButton restockBtn;
    private JButton replenishBtn;
    private JButton upPriceBtn;
    private JButton collectBtn;
    private JButton doneBtn;
    private JTextArea display;
    private JMenuBar menu;
    private JMenu maintenance;
    private JMenuItem restock;
    private JMenuItem replenish;
    private JMenuItem updatePrice;
    private JMenuItem collect;
    private JTextField textBox;

    /**
     * Creates an instance of RegularVm's View
     */
    public RegularVMView(){
        rvmPanel = new RegularVMPanel();
        rvmModel = new RegularVMModel();
        rVmController = new RegularVMController(rvmModel, this);
        rvmModel.initializeRegister();
        rvmModel.initializeInventory();
        

    /*-------------------------ImageIcon-----------------------------*/
        ImageIcon logo = new ImageIcon("logo.png");
    /*------------------End of ImageIcon-----------------------------*/

    /*------------------------------------JLabel----------------------------------------*/
        item = new JLabel("Item:");
        item.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        item.setBounds(20, 10, 110, 30);

        denomination = new JLabel("Denomination:");
        denomination.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        denomination.setBounds(20, 60, 100, 30);

        priceLbl = new JLabel("Price: ");
        priceLbl.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        priceLbl.setBounds(20, 60, 70, 30);

        qtyLbl = new JLabel("Quantity: ");
        qtyLbl.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        qtyLbl.setBounds(10, 70, 70, 30);

    /*--------------------------------End of JLabel--------------------------------------*/
        
    /*--------------------------------------JComboBox----------------------------------------*/
        itemList = new JComboBox<>(rvmModel.getItems().toArray(new Item[0]));
        itemList.setBounds(60, 10, 110, 30);

        denominationList = new JComboBox<>(rvmModel.getDenominationList().toArray(new Denomination[0]));
        denominationList.setBounds(120, 60, 80, 30);
    /*--------------------------------End of JComboBox--------------------------------------*/    
        
    /*--------------------------------JSlider--------------------------------------*/
        slider = new JSlider(0, 10, 5);
        slider.setPreferredSize(new Dimension(150, 50));
        slider.setBounds(20, 110, 150, 50);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(1);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(2);
        slider.setPaintLabels(true);
    /*--------------------------------End of JSlider-------------------------------*/
    
    /*--------------------------------JButton--------------------------------------*/
        addBtn = new JButton("Add");
        addBtn.setFocusable(false);
        addBtn.setBounds(20, 170, 60, 30);

        payBtn = new JButton("Pay");
        payBtn.setFocusable(false);
        payBtn.setBounds(110, 170, 60, 30);

        restockBtn = new JButton("Restock");
        restockBtn.setFocusable(false);
        restockBtn.setBounds(20, 120, 100, 30);

        replenishBtn = new JButton("Replenish");
        replenishBtn.setFocusable(false);
        replenishBtn.setBounds(20, 120, 100, 30);

        upPriceBtn = new JButton("Update");
        upPriceBtn.setFocusable(false);
        upPriceBtn.setBounds(20, 120, 100, 30);

        collectBtn = new JButton("Collect");
        collectBtn.setFocusable(false);
        collectBtn.setBounds(35, 130, 100, 30);

        doneBtn = new JButton("Done");
        doneBtn.setFocusable(false);
        doneBtn.setBounds(50, 170, 70, 30);
    /*--------------------------------End of JButton--------------------------------------*/

    /*--------------------------------JTextArea--------------------------------------*/
        display = new JTextArea(" ");
        display.setBounds(225, 10, 360, 200);
        display.setEditable(false);
    /*--------------------------------End of JTextArea--------------------------------------*/

    /*--------------------------------JTextField--------------------------------------*/
        textBox = new JTextField(" ");
        textBox.setPreferredSize(new Dimension(100, 30));
    /*--------------------------------End of JTextField--------------------------------------*/

    /*--------------------------------JMenuItem--------------------------------------*/
        restock = new JMenuItem("Restock Items");
        replenish = new JMenuItem("Replenish Register");
        updatePrice = new JMenuItem("Update Item Price");
        collect = new JMenuItem("Collect Cash");

        restock.setFont(new Font("Calibri", Font.PLAIN, 15));
        replenish.setFont(new Font("Calibri", Font.PLAIN, 15));
        updatePrice.setFont(new Font("Calibri", Font.PLAIN, 15));
        collect.setFont(new Font("Calibri", Font.PLAIN, 15));
    /*--------------------------------End of JMenuItem--------------------------------------*/

    /*--------------------------------JMenu--------------------------------------*/
        maintenance = new JMenu("Maintenance");
        maintenance.add(restock);
        maintenance.add(replenish);
        maintenance.add(updatePrice);
        maintenance.add(collect);
    /*--------------------------------End of JMenu--------------------------------------*/

    /*--------------------------------JMenuBar--------------------------------------*/
        menu = new JMenuBar();
        menu.add(maintenance);
    /*--------------------------------End of JMenuBar--------------------------------------*/
        
    /*--------------------------------JLayeredPane--------------------------------------*/
        layer = new JLayeredPane();
        layer.setPreferredSize(new Dimension(200, 280));
        layer.setBackground(new Color(0x4683b7));
        layer.setOpaque(true);
        layer.add(item, JLayeredPane.DRAG_LAYER);
        layer.add(denomination, JLayeredPane.DRAG_LAYER);
        layer.add(itemList, JLayeredPane.DRAG_LAYER);
        layer.add(denominationList, JLayeredPane.DRAG_LAYER);
        layer.add(slider, JLayeredPane.DRAG_LAYER);
        layer.add(addBtn, JLayeredPane.DRAG_LAYER);
        layer.add(payBtn, JLayeredPane.DRAG_LAYER);
        layer.add(display, JLayeredPane.DRAG_LAYER);
        layer.add(qtyLbl, JLayeredPane.DRAG_LAYER);
        layer.add(textBox, JLayeredPane.DRAG_LAYER);
        layer.add(priceLbl, JLayeredPane.DRAG_LAYER);
        layer.add(restockBtn, JLayeredPane.DRAG_LAYER);
        layer.add(replenishBtn, JLayeredPane.DRAG_LAYER);
        layer.add(upPriceBtn, JLayeredPane.DRAG_LAYER);
        layer.add(collectBtn, JLayeredPane.DRAG_LAYER);
        layer.add(doneBtn, JLayeredPane.DRAG_LAYER);
    /*--------------------------------End of JLayeredPane--------------------------------------*/
        
    /*--------------------------------View Hiders--------------------------------------*/
        hideRestockView();
        hideReplenishView();
        hideUpdatePriceView();
        hideCollectView(); 
    /*--------------------------------End of View Hiders--------------------------------------*/

    /*--------------------------------JFrame--------------------------------------*/
        this.setTitle("Regular Vending Machine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.setJMenuBar(menu);
        this.add(rvmPanel);
        this.add(layer, BorderLayout.SOUTH);
        this.pack();
    /*--------------------------------End of JFrame--------------------------------------*/

    /*--------------------------------ActionListeners--------------------------------------*/
        addBtn.addActionListener(rVmController::triggerAddBtn);
        payBtn.addActionListener(rVmController::triggerPayBtn);
        restock.addActionListener(rVmController::triggerRestock);
        replenish.addActionListener(rVmController::triggerReplenish);
        updatePrice.addActionListener(rVmController::triggerUpdatePrice);
        collect.addActionListener(rVmController::triggerCollect);
        doneBtn.addActionListener(rVmController::triggerDoneBtn);
    /*--------------------------------End of ActionListeners--------------------------------------*/
    }

    /**
     * getter for the selected item from the item list
     * @return The selected item from the JComboBox
     */
    public Item getItemSelected(){
        return (Item) itemList.getSelectedItem();
    }

    /**
     * getter for the selected denomination from the denomination list
     * @return The selected denomination from the JComboBox
     */
    public Denomination getDenominationSelected(){
        return (Denomination) denominationList.getSelectedItem();
    }

    /**
     * getter for the value of the selected denomination from the denomination list
     * @return The value of the selected denomination
     */
    public double getDenomListSelectedItem(){
        Denomination selectedDenom = getDenominationSelected();
        return selectedDenom.getDenomination();
    }

    /**
     * getter the value of the slider
     * @return The value of the slider
     */
    public int getSliderValue(){
        int nQty;

        nQty = slider.getValue();

        return nQty;
    }

    /**
     * getter for the value from the text box
     * @return The value from the text box as a double
     */
    public double getTextBoxValue(){
        double value;

        value = Double.parseDouble(textBox.getText());

        return value;
    }

    /**
     * sets the text of the display area with the provided feedback
     * @param feedback The text to display in the JTextArea
     */
    public void setDisplayTextArea(String feedback){
        display.setText(feedback + "\n");
    }

     /**
     * displays the inventory in the JTextArea
     * @param inventory A map containing the inventory with products as keys and quantities as values
     */
    public void displayInventory(Map<Product, Integer> inventory){
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory:\n");
        for (Map.Entry<Product, Integer> entry : inventory.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            sb.append(product.getName()).append(": ").append(qty).append("\n");
        }
        display.setText(sb.toString());
    }

    /**
     * displays the cash register in the JTextArea
     * @param register A map containing the cash register with denominations as keys and quantities as values
     */
    public void displayRegister(Map<Denomination, Integer> register) {
        StringBuilder sb = new StringBuilder();
        sb.append("Register:\n");
        for (Map.Entry<Denomination, Integer> entry : register.entrySet()) {
            Denomination denomination = entry.getKey();
            int quantity = entry.getValue();
            sb.append(denomination.getDenomination()).append(": ").append(quantity).append("\n");
        }
        display.setText(sb.toString());
    }

    /**
     * displays the item prices in the JTextArea
     * @param itemPrices A map containing the item prices with products as keys and prices as values
     */
    public void displayItemPrices(Map<Product, Double> itemPrices) {
        StringBuilder sb = new StringBuilder();
        sb.append("Item Prices:\n");
        for (Map.Entry<Product, Double> entry : itemPrices.entrySet()) {
            Product product = entry.getKey();
            double price = entry.getValue();
            sb.append(product.getName()).append(": ").append(price).append("\n");
        }
        display.setText(sb.toString());
    }

    /********************************
     * ---------SHOW VIEWS--------- *
     ********************************/
     /**
     * shows the view for restocking the vending machine
     */
    public void showRestockView() {
        restockBtn.setVisible(true);
        slider.setVisible(true);
        doneBtn.setVisible(true);
        slider.setBounds(20, 60, 150, 50);
        hideDenominationView();
        hideTransactionBtns();
    }
    
    /**
     * shows the view for replenishing the cash register
     */
    public void showReplenishView(){
        replenishBtn.setVisible(true);
        doneBtn.setVisible(true);
        slider.setVisible(false);
        textBox.setVisible(true);
        qtyLbl.setVisible(true);
        denomination.setBounds(10, 10, 110, 30);
        denominationList.setBounds(110, 10, 110, 30);
        textBox.setBounds(80, 70, 60, 30);
        hideTransactionBtns();
        hideItemsView();
    }

     /**
     * shows the view for updating the price of an item
     */
    public void showUpdatePriceView(){
        upPriceBtn.setVisible(true);
        textBox.setVisible(true);
        priceLbl.setVisible(true);
        slider.setVisible(false);
        doneBtn.setVisible(true);
        textBox.setBounds(65, 60, 100, 30);
        hideDenominationView();
        hideTransactionBtns();
    }

    /**
     * shows the view for collecting cash from the cash register
     */
    public void showCollectView(){
        collectBtn.setVisible(true);
        slider.setVisible(false);
        doneBtn.setVisible(true);
        textBox.setVisible(true);
        qtyLbl.setVisible(true);
        denomination.setBounds(10, 30, 110, 30);
        denominationList.setBounds(110, 30, 110, 30);
        textBox.setBounds(80, 70, 70, 30);
        hideItemsView();
        hideTransactionBtns();
    }

    /**
     * shows the buttons for adding and paying in the transaction view
     */
    public void showTransactionBtns(){
        addBtn.setVisible(true);
        payBtn.setVisible(true);
    }

    /**
     * shows the denomination view
     */
    public void showDenominationView() {
        denominationList.setVisible(true);
        denomination.setVisible(true);
    }

    /**
     * shows the items view
     */
    public void showItemsView(){
        item.setVisible(true);
        itemList.setVisible(true);
    }

    /**
     * shows the transaction view with items, denominations, and transaction buttons
     */
    public void showTransactionView(){
        showItemsView();
        showDenominationView();
        showTransactionBtns();
        slider.setVisible(true);
        slider.setBounds(20, 110, 150, 50);
        denomination.setBounds(20, 60, 100, 30);
        denominationList.setBounds(120, 60, 80, 30);
    }
    /********************************
     * ---------HIDE VIEWS--------- *
     ********************************/

    /**
     * hides the view for restocking the vending machine
     */
    public void hideRestockView() {
        restockBtn.setVisible(false);
        doneBtn.setVisible(false);
    }

     /**
     * hides the view for replenishing the cash register
     */
    public void hideReplenishView(){
        replenishBtn.setVisible(false);
        doneBtn.setVisible(false);
        textBox.setVisible(false);
        qtyLbl.setVisible(false);
    }

    /**
     * hides the view for updating the price of an item
     */
    public void hideUpdatePriceView(){
        upPriceBtn.setVisible(false);
        textBox.setVisible(false);
        priceLbl.setVisible(false);
        doneBtn.setVisible(false);
    }

    /**
     * hides the view for collecting cash from the cash register
     */
    public void hideCollectView(){
        collectBtn.setVisible(false);
        qtyLbl.setVisible(false);
        textBox.setVisible(false);
        doneBtn.setVisible(false);
    }

    /**
     * hides the buttons for adding and paying in the transaction view
     */
    public void hideTransactionBtns(){
        addBtn.setVisible(false);
        payBtn.setVisible(false);
    }

    /**
     * hides the denomination view
     */
    public void hideDenominationView() {
        denominationList.setVisible(false);
        denomination.setVisible(false);
    }

    /**
     * hides the items view
     */
    public void hideItemsView(){
        item.setVisible(false);
        itemList.setVisible(false);
    }
     
}
