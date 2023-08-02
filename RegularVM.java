import java.util.*;

/**
 * RegularVM class contains all the attributes and behaviors of the Regular Vending Machine
 */
public class RegularVM{
    CashRegister register;
    Inventory inventory;

    /**
     * creates an instance of regular vending machine
     * @param register the cash register, which is responsible for transaction related actions
     * @param inventory is the inventory, contains the list of products and its quantity
     */
    public RegularVM(CashRegister register, Inventory inventory){
        this.register = register;
        this.inventory = inventory;
    }

    /**
     * performs the vending transaction
     * @param dPayment is the total payment entered by the customer
     * @param item is the item chosen by the customer
     * @return a boolean value signifying success or failure of transaction
     */
    public boolean doTransaction(double dPayment, Item item){
        double dTotalCost;
        boolean isSuccessful = false;

        register.calculateTotalCost(item);
        dTotalCost = register.getTotalCost();

        if(dPayment >= dTotalCost){
            register.receivePayment(dPayment);
            register.calculateChange(dPayment, dTotalCost);
            if(register.isChangeEnough(dPayment) && (inventory.getProductQy(item) > 0)){
                dispenseItem(item);
                register.produceChange(dPayment);
                isSuccessful = true;
            }
        }
        return isSuccessful;
    }
    
    /**
     * dispenses the item, the method also updates the inventory of the chosen product
     * @param item is the product chosen by the customer
     */
    public void dispenseItem(Item item){
        inventory.reduceProduct(item, 1);
    }
    
    /**
     * restocks the products
     * @param product the product to be restocked
     * @param productQty the quantity of the product to be added
     */
    public void restockItem(Product product, int productQty){
        inventory.restockProduct(product, productQty);
    }

    /**
     * replenishes the cash register given the denomination and its quantity  
     * @param denomination is the denomination
     * @param denomQty is the quantity to be added
     */
    public void replenishDenomination(Denomination denomination, int denomQty){
        register.addMoney(denomination, denomQty);
    }

    /**
     * updates the proces of the product
     * @param product is the product
     * @param newPrice is the new price of the product
     */
    public void updatePrice(Product product, double newPrice){
        inventory.setNewProductPrice(product, newPrice);
    }

    /**
     * method for ower to collect cash from register
     * @param denomination is the denomination
     * @param denomQty is the quantity collected
     */
    public void collectCash(Denomination denomination, int denomQty){
        register.collectPayment(denomination, denomQty);
    }

    /**
     * method that calls the inventory getter from invetory class
     * @return the inventory of the products, a list of products and its stock
     */
    public Map<Product, Integer> returnInventory(){
        return inventory.getInventory();
    }

    /**
     * getter for the item's stock
     * @param item is the item
     * @return the item's stock
     */
    public int getItemQty(Item item){
        return inventory.getProductQy(item);
    }
}
