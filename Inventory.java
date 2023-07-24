import java.util.*;

public class Inventory {
    private Map<Product, Integer> productList;

    public Inventory() {
        productList = new HashMap<>();
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Product product : productList.keySet()) {
            int quantity = productList.get(product);
            System.out.println(product.getName() + ": " + quantity);
        }
    }

    public void restockProduct(Product product, int nRestockQty) {
        if (product instanceof Item) {
            restockItem(product, nRestockQty);
        } else if (product instanceof Topping) {
            restockTopping(product, nRestockQty);
        } else {
            throw new IllegalArgumentException("Invalid Product Type");
        }
    }

    public void reduceProduct(Product product, int nReduceQty) {
        if (product instanceof Item) {
            reduceItem(product, nReduceQty);
        } else if (product instanceof Topping) {
            reduceTopping(product, nReduceQty);
        } else {
            throw new IllegalArgumentException("Invalid Product Type");
        }
    }

    public void restockItem(Product product, int nRestockQty) {
        int nCurrentQty = productList.getOrDefault(product, 0);
        productList.put(product, nCurrentQty + nRestockQty);
    }

    public void reduceItem(Product product, int nReduceQty) {
        int nCurrentQty = productList.getOrDefault(product, 0);
        int nNewQty = nCurrentQty - nReduceQty;
        if (nNewQty < 0) {
            nNewQty = 0; 
        }
        productList.put(product, nNewQty);
    }

    public void restockTopping(Product product, int nTopQty) {
        int nCurrentQty = productList.getOrDefault(product, 0);
        productList.put(product, nCurrentQty + nTopQty);
    }

    public void reduceTopping(Product product, int nReduceQty) {
        int nCurrentQty = productList.getOrDefault(product, 0);
        int nNewQty = nCurrentQty - nReduceQty;
        if (nNewQty < 0) {
            nNewQty = 0; 
        }
        productList.put(product, nNewQty);
    }
    
}
