import java.util.ArrayList;

public class Inventory {
    
    private int nItemQty;
    private int nToppingQty;
    private ArrayList<Item> itemList;
    private ArrayList<Topping> toppingList;

    public Inventory(Item item, int nItemQty) {
        this.itemList = new ArrayList<Item>();
        this.toppingList = new ArrayList<Topping>();
        this.itemList.add(item);
        this.nItemQty = nItemQty;
    }

    public int getItemQty() { 
        return nItemQty;
    }

    public int getToppingQty() {
        return nToppingQty;
    }

    public void restockItem(Item item, int nRestockQty) {
        
        int nCurrentItemQty = getItemQty();
        int nNewItemQty = nCurrentItemQty + nRestockQty;

        if (nCurrentItemQty == 10) {
            System.out.println("Restocking unsuccessful." + item.getItem() + " does not need restocking.\n");
        } 
        
        else if (nCurrentItemQty < 10) {
            nItemQty = nNewItemQty;
            System.out.println("Restocking...\n" + item.getItem() + " restocked successfully.\n");
        }
    }
  
    public void restockTopping(Topping topping, int nTopQty) {

        int nCurrentTopQty = getToppingQty();
        int nNewTopQty = nCurrentTopQty + nTopQty;
    
        if (nCurrentTopQty == 10) {
           System.out.println("Restocking unsuccessful." + topping.getToppingName() + " does not need restocking.\n");
        } 
        
        else if (nCurrentTopQty < 10) {
            nToppingQty = nNewTopQty;
            System.out.println("Restocking...\n" + topping.getToppingName() + " restocked successfully.\n");
        }
    }

}
