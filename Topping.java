/**
 * Topping class contains the toppings for the newly created  or mixed items.
 * These products cannot be sold separately.
 */
public class Topping extends Product {

    /**
     * creates an instance of a topping given its name and price
     * @param sTopping is the name of the topping
     * @param dPrice is the price of the topping
     * @param nCalories is the calories of the toppings
     */
    public Topping(String sTopping, double dPrice, int nCalories) {

        super(sTopping, dPrice, nCalories);
    }

    /**
     * sets the price of the topping
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
    
}
