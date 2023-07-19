import java.util.*;

public class Inventory {
    
    private int nProductQty;
    private Map<Product, Integer> productList;

    public Inventory() {
        productList = new HashMap<>();
    }

    public void restockItem(Product product, int nRestockQty) {

        int nCurrentQty;

        if (productList.containsKey(product)) {
            nCurrentQty = productList.get(product);
            productList.put(product, nCurrentQty + nRestockQty);
        } else {
            productList.put(product, nRestockQty);
        }
    }

    public void restockTopping(Product product, int nTopQty) {

        int nCurrentQty;

        if (productList.containsKey(product)) {
            nCurrentQty = productList.get(product);
            productList.put(product, nCurrentQty + nTopQty);
        } else {
            productList.put(product, nTopQty);
        }
    }

}
