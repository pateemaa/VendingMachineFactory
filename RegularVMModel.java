import java.util.*;

/**
 * This class contains all the attributes of the model of the regular vending machine
 */
public class RegularVMModel {
    
    private ArrayList<Item> drinks;
    private ArrayList<Denomination> cash;
    private Map<Denomination, Integer> payment;
    private RegularVM rvm;

    /**
     * creates an instance of the RegularVMModel
     */
    public RegularVMModel(){
        this.drinks = new ArrayList<>();
        this.cash = new ArrayList<>();
        this.payment = new HashMap<>();
        this.rvm = new RegularVM(new CashRegister(), new Inventory());
    }

    /**
     * initializes the inventory of drinks with default items and quantities
     */
    public void initializeInventory(){
        drinks.add(new Item("Rum", 50.00, 54));
        drinks.add(new Item("Lime Juice", 40.00, 60));
        drinks.add(new Item("Soda Water", 25.00, 0));
        drinks.add(new Item("Gin", 65.00, 110));
        drinks.add(new Item("Tonic", 85.00, 90));
        drinks.add(new Item("Tequila", 90, 97));
        drinks.add(new Item("Whiskey", 55, 105));
        drinks.add(new Item("Orange Juice", 20.00, 111));
        drinks.add(new Item("Vodka", 65.00, 97));
        drinks.add(new Item("Vermouth", 70.00, 95));

        for(Item i : drinks){
            rvm.restockItem(i, 10);;
        }
    }
    
    /**
     * initializes the cash register with default denominations and quantities
     */
    public void initializeRegister(){
        cash.add(new Denomination(1.00));
        cash.add(new Denomination(5.00));
        cash.add(new Denomination(10.00));
        cash.add(new Denomination(20.00));
        cash.add(new Denomination(50.00));
        cash.add(new Denomination(100.00));
        cash.add(new Denomination(200.00));
        cash.add(new Denomination(500.00));
        cash.add(new Denomination(1000.00));

        for(Denomination d : cash){
            rvm.replenishDenomination(d, 10);;
        }
    }

    /**
     * getter for the list of items in the vending machine
     * @return an ArrayList of items
     */
    public ArrayList<Item> getItems(){
        return this.drinks;
    }

    /**
     * getter for the list of denominations of cash in the vending machine
     * @return an ArrayList of cash denominations
     */
    public ArrayList<Denomination> getDenominationList(){
        return this.cash;
    }

    /**
     * matches the selected denomination with its quantity and adds it to the payment map
     * @param denom The denomination to match
     * @param denomQty The quantity of the denomination
     * @return boolean value validating the denomination
     */
    public boolean matchDenomination(double denom, int denomQty) {
        boolean isValid = false;
        for (Denomination denomination : cash) {
            if (denomination.getDenomination() == denom) {
                payment.put(denomination, denomQty);
                isValid = true;
            }
        }
        return isValid;
    }

    /**
     * getter the payment map representing the selected denominations and their quantities
     * @return a payment map with Denomination as keys and Integer as values
     */
    public Map<Denomination, Integer> getPayment(){
        return payment;
    }

    /**
     * calculates the total payment amount based on the selected denominations and their quantities
     * @return the total payment amount as a double
     */
    public double getPaymentTotal() {
        double dTotal = 0;
        for (Map.Entry<Denomination, Integer> entry : payment.entrySet()) {
            Denomination denomination = entry.getKey();
            int paymentQty = entry.getValue();
            dTotal += paymentQty * denomination.getDenomination();
        }
        return dTotal;
    }
    
    /**
     * processes the transaction by checking if the payment is sufficient for the selected item's price
     * @param dPayment is the total payment amount provided by the user
     * @param item is the selected item for the transaction
     * @return boolean value for transaction status
     */
    public boolean processTransaction(double dPayment, Item item){
        return rvm.doTransaction(dPayment, item);
    }

    /**
     * restocks the specified item in the vending machine with the given quantity
     * @param item is the item to be restocked
     * @param productQty is the quantity to be added to the inventory of the item
     */
    public void restockDrinks(Item item, int productQty){
        try {
            if(productQty < 0){
                throw new IllegalArgumentException("Quantity must be a non-negative number");
            }
            rvm.restockItem(item, productQty);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    /**
     * replenishes the specified denomination in the cash register with the given quantity
     * @param denomination is the denomination to be replenished
     * @param denomQty is the quantity to be added to the cash register for the denomination
     */
    public void replenishRegister(Denomination denomination, int denomQty){
        try {
            if (denomQty < 0) {
                throw new IllegalArgumentException("Quantity must be a non-negative number");
            }
            rvm.replenishDenomination(denomination, denomQty);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * updates the price of the specified product in the vending machine
     * @param product is the product whose price is to be updated
     * @param newPrice is the new price to be set for the product
     */
    public void updateProductPrice(Product product, double newPrice){
        try {
            if (newPrice < 0) {
                throw new IllegalArgumentException("Price must be a non-negative number");
            }
            rvm.updatePrice(product, newPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * collects cash from the cash register for the specified denomination and quantity
     * @param denomination is the denomination of cash to be collected
     * @param denomQty is the quantity of the denomination to be collected
     */
    public void collectMoney(Denomination denomination, int denomQty){
        try {
            if (denomQty < 0) {
                throw new IllegalArgumentException("Quantity must be a non-negative number");
            }
            rvm.collectCash(denomination, denomQty);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * retrieves the current inventory of products in the vending machine
     * @return a map containing the products as keys and their respective quantities as values
     */
    public Map<Product, Integer> checkInventory(){
        Map<Product, Integer> inventory = rvm.returnInventory();
        return inventory;
    }

    /**
     * returns the quantity of the specified item in the vending machine's inventory
     * @param item is the item for which the quantity is to be retrieved
     * @return is the quantity of the item in the inventory
     */
    public int returnItemQty(Item item){
       return rvm.getItemQty(item);
    }

}
