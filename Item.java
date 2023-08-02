/**
 * The Item cass pertains to the main products if the vending machine.
 * These products can be sold individually or combined to create a new product.
 */
public class Item extends Product {

    /**
     * creates an instance of an Item given its name and price
     * @param sName is the name of the item
     * @param dPrice is the price of the item
     * @param nCalories is the calories of the item
     */
    public Item(String sName, double dPrice, int nCalories) {
        
        super(sName, dPrice, nCalories);
    }

    /**
     * setter for the price of the item
     */
    @Override
    public void setPrice(double dPrice) {
        
        if (dPrice > 0) {
            super.setPrice(dPrice);
        } 
        
        else {
            System.out.println("Error! Invalid Price Input");
        }
    }

    /**
     * returns the name of the item as a string
     */
    public String toString() {
        return sName; 
    }
}
