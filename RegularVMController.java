import java.awt.event.ActionEvent;
import java.util.Map;

/**
 * This class contains the attributes and behaviors of the controller for regular vending machine
 */
public class RegularVMController {
    private RegularVMModel model;
    private RegularVMView view;
    private boolean isRestockActive;
    private boolean isReplenishActive;
    private boolean isUpdateActive;
    private boolean isCollectActive;

    /**
     * Creates an instance of the controller for the regular vending machine.
     * 
     * @param model The RegularVMModel object representing the model of the vending machine.
     * @param view The RegularVMView object representing the view of the vending machine.
     */
    public RegularVMController(RegularVMModel model, RegularVMView view){
        this.model = model;
        this.view = view;

        this.model.initializeRegister();
    }

 /*---------------------------BUTTON TRIGGERS-------------------------- */

  /**
     * Trigger for the Add button
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerAddBtn(ActionEvent e){
        String cashList = "Payment\n";
        double dDen, dTotalPayment;
        int denQty = view.getSliderValue();
        dDen = view.getDenomListSelectedItem();
        model.matchDenomination(dDen, denQty);
        
        for (Map.Entry<Denomination, Integer> entry : model.getPayment().entrySet()) {
            Denomination denomination = entry.getKey();
            int paymentQty = entry.getValue();
            cashList += paymentQty + " " + denomination.getDenomination() + "\n";
        }
            dTotalPayment = model.getPaymentTotal();
            cashList += "Total: " + String.format("%.2f", dTotalPayment);
            view.setDisplayTextArea(cashList);        
    }

     /**
     * Triggered for the Pay button
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerPayBtn(ActionEvent e){
        double dTotalPayment = model.getPaymentTotal();
        Item item = view.getItemSelected();

        if(model.processTransaction(dTotalPayment, item)){
            view.setDisplayTextArea("Payment successful!");
        }else{
            view.setDisplayTextArea("Payment unsuccessful!");
        }
        view.rvmPanel.updateDisplay();
    }

    /**
     * Trigger for the Restock button
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerRestockBtn(ActionEvent e){
        Item item = view.getItemSelected();
        int productQty = view.getSliderValue();
        model.restockDrinks(item, productQty);
        view.displayInventory(model.checkInventory());
        view.rvmPanel.updateDisplay();
    }

    /**
     * Trigger for the Replenish button
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerReplenishBtn(ActionEvent e){
        Denomination denomination = view.getDenominationSelected();
        int denomQty = (int) view.getTextBoxValue();
        model.replenishRegister(denomination, denomQty);
    }

    /**
     * Trigger for the Update button
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerPriceUpdateBtn(ActionEvent e){
        Item item = view.getItemSelected();
        double newPrice = view.getTextBoxValue();
        model.updateProductPrice(item, newPrice);
        view.rvmPanel.updateDisplay();
    }

     /**
     * Trigger for the Collect button
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerCollectBtn(ActionEvent e){
        Denomination denomination = view.getDenominationSelected();
        int denomQty = (int) view.getTextBoxValue();
        model.collectMoney(denomination, denomQty);
    }

    /**
     * Trigger for the Done button
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerDoneBtn(ActionEvent e){
        if(isRestockActive){
            view.hideRestockView();
        }else if(isReplenishActive){
            view.hideReplenishView();
        }else if(isUpdateActive){
            view.hideUpdatePriceView();
        }else if(isCollectActive){
            view.hideCollectView();
        }
        view.showTransactionView();
    }
/*---------------------------END OF BUTTON TRIGGERS-------------------------- */

/*---------------------------------MENU ITEM TRIGGERS------------------------------------- */
    /**
     * Trigger for the Restock Items menu item
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerRestock(ActionEvent e){
        isRestockActive = true;
        isReplenishActive = false;
        isCollectActive = false;
        isUpdateActive = false;
        view.showRestockView();
    }

    /**
     * Trigger for the Replenish Register menu item
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerReplenish(ActionEvent e){
        isRestockActive = false;
        isReplenishActive = true;
        isCollectActive = false;
        isUpdateActive = false;
        view.showReplenishView();
    }

    /**
     * Trigger ofr the Update Item Price menu item
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerUpdatePrice(ActionEvent e){
        isRestockActive = false;
        isReplenishActive = false;
        isCollectActive = false;
        isUpdateActive = true;
        view.showUpdatePriceView();
    }

    /**
     * Trigger ofr the Collect Cash menu item
     * 
     * @param e the ActionEvent object that represents the event when the button is pressed
     */
    public void triggerCollect(ActionEvent e){
        isRestockActive = false;
        isReplenishActive = false;
        isCollectActive = true;
        isUpdateActive = false;
        view.showCollectView();
    }

/*---------------------------------END OF MENU ITEM TRIGGERS------------------------------------- */
}
