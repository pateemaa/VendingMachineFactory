import java.util.*;
/**
 * Inventory class contains the attributes and behaviors of an inventory.
 * It handles the manipulation of the quantity of the products (item and toppings)
 */
public class Inventory {
    private Map<Product, Integer> productList;
    private ArrayList<Item> itemList;
    private ArrayList<Topping> toppingList;

    /**
     * creates an instance of Inventory
     */
    public Inventory() {
        productList = new HashMap<>();
        itemList = new ArrayList<>();
        toppingList = new ArrayList<>();
    }

    /**
     * getter for the inventory
     * @return the map of the inventory containing the list of products and its quantity
     */
    public Map<Product, Integer> getInventory(){
        return productList;
    }
    /**
     * displays the current inventory
     */
    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Product product : productList.keySet()) {
            int quantity = productList.get(product);
            System.out.println(product.getName() + ": " + quantity);
        }
    }

    /**
     * getter for the product's stock quantity
     * @param product is the product
     * @return the stock quantity of the product
     */
    public int getProductQy(Product product){
        for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
            if (entry.getKey().equals(product)) {
                return entry.getValue();
            }
        }
        return 0;
    }
    /**
     * restocks the product
     * @param product is the product (item or topping)
     * @param nRestockQty is the new stock to be added
     */
    public void restockProduct(Product product, int nRestockQty) {

        try {
            if(nRestockQty < 0){
                throw new IllegalArgumentException("Quantity must be a non-negative number");
            }

            if (product instanceof Item || product instanceof Topping) {
                int nCurrentQty = productList.getOrDefault(product, 0);
                productList.put(product, nCurrentQty + nRestockQty);
            }else {
                System.out.println("Invalid Product Type");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }

    /**
     * reduces the quantity of the product
     * @param product is the product
     * @param nReduceQty is the quantity of teh product to be reduced
     */
    public void reduceProduct(Product product, int nReduceQty) {
        try {
            if(nReduceQty < 0){
                throw new IllegalArgumentException("Quantity must be a non-negative number");
            }
            int nCurrentQty = productList.getOrDefault(product, 0);
            int nNewQty = nCurrentQty - nReduceQty;
            if (product instanceof Item || product instanceof Topping) {
                productList.put(product, nNewQty);
            } else {
                System.out.println("Invalid Product Type");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * adds a product its respective list
     * @param prod is the product
     * @param prodQty is the quantity of the product
     */
    public void addToProductList(Product prod, int prodQty){

        productList.put(prod, prodQty);

        if(prod instanceof Item){
            itemList.add((Item) prod);
        }else if (prod instanceof Topping){
            toppingList.add((Topping) prod);
        }
    }

    /**
     * setter for the new price of the product
     * @param prod is the name of the product
     * @param newPrice is the new price of the product
     */
    public void setNewProductPrice(Product prod, double newPrice){
        Item item = (Item) prod;
        Topping top = (Topping) prod;

        if(prod instanceof Item){
            item.setPrice(newPrice);
        }else if(prod instanceof Topping){
            top.setPrice(newPrice);
        }
    }
}
