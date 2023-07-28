import java.util.*;

public class Inventory {
    private Map<Product, Integer> productList;
    private ArrayList<Item> itemList;
    private ArrayList<Topping> toppingList;

    public Inventory(Product prod, int prodQty) {
        productList = new HashMap<>();
        itemList = new ArrayList<>();
        toppingList = new ArrayList<>();
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Product product : productList.keySet()) {
            int quantity = productList.get(product);
            System.out.println(product.getName() + ": " + quantity);
        }
    }

    public void restockProduct(Product product, int nRestockQty) {
        if (product instanceof Item || product instanceof Topping) {
            int nCurrentQty = productList.getOrDefault(product, 0);
            productList.put(product, nCurrentQty + nRestockQty);
        } else {
            throw new IllegalArgumentException("Invalid Product Type");
        }
    }

    public void reduceProduct(Product product, int nReduceQty) {
        if (product instanceof Item || product instanceof Topping) {
            int nCurrentQty = productList.getOrDefault(product, 0);
            int nNewQty = nCurrentQty - nReduceQty;
            if (nNewQty < 0) {
                nNewQty = 0; 
            }
            productList.put(product, nNewQty);
        } else {
            throw new IllegalArgumentException("Invalid Product Type");
        }
    }
    
    public void addProduct(Product prod, int prodQty){

        productList.put(prod, prodQty);

        if(prod instanceof Item){
            itemList.add((Item) prod);
        }else if (prod instanceof Topping){
            toppingList.add((Topping) prod);
        }
    }
}
