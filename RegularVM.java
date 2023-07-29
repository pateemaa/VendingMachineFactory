import java.util.*;

public class RegularVM{

    private double dSales;
    private Map<Item, Integer> endInv;
    private Map<Item, Integer> startInv;

    public RegularVM(){
        dSales = 0.00;
        startInv = new HashMap<>();
        endInv = new HashMap<>();
    }

    public void printSummary(){
        
        System.out.println("Starting Inventory: ");
        for (Item item : startInv.keySet()) {
            int quantity = startInv.get(item);
            System.out.println(item.getName() + ": " + quantity);
        }

        System.out.println("Ending Inventory: ");
        for (Item item : endInv.keySet()) {
            int quantity = endInv.get(item);
            System.out.println(item.getName() + ": " + quantity);
        }

        System.out.println("Total Sales: " + dSales);
    }
    
    public void setStartingInventory(ArrayList<Item> itemList) {
        startInv.clear();
    
        for (Item item : itemList) {
            int quantity = item.getQuantity();
            startInv.put(item, quantity);
        }
    }

    public void setEndingInventory(ArrayList<Item> itemList) {
        endInv.clear();
    
        for (Item item : itemList) {
            int quantity = item.getQuantity();
            endInv.put(item, quantity);
        }
    }
    

    public double getSales(){
        return dSales;
    }

    public void dispenseItem(Item item, double payment) {
        if (item.getQuantity() > 0) {
            if (payment >= item.getPrice()) {
                // Dispensing the item
                System.out.println("Dispensing " + item.getName() + "...");
    
                // Update the sales and inventory
                dSales += item.getPrice();
                item.setQuantity(item.getQuantity() - 1);
    
                // Update the ending inventory
                int currentEndingQty = endInv.getOrDefault(item, 0);
                endInv.put(item, currentEndingQty + 1);
            } else {
                System.out.println("Error: Insufficient payment");
            }
        } else {
            System.out.println("Error: Item not available");
        }
    }
    
    
}
