/**
 * The Product class contains all the similar attributes of the types of products in the vending machine.
 */

public abstract class Product {
    
    protected String sName;
    private double dPrice;
    private int nCalories;

    /**
     * creates an instance of product given its name and price
     * @param sName is the name of the product
     * @param dPrice is the price of the product
     * @param nCalories is the product's calorie count
     */
    public Product(String sName, double dPrice, int nCalories) {
        this.sName = sName;
        this.dPrice = dPrice;
        this.nCalories = nCalories;
    }

    /**
     * getter for the name of the product
     * @return name of product
     */
    public String getName() {
        return sName;
    }

    /**
     * setter for price of the product
     * @param dPrice is the price of the product
     */
    public void setPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    /**
     * getter for the product's price
     * @return the price of the product
     */
    public double getPrice() {
        return dPrice;
    }

    /**
     * getter for product's calorie count
     * @return product's calories
     */
    public int getCalories(){
        return nCalories;
    }
}
