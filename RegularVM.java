import java.utli.*;

public class RegularVM{

    private double dSales;
    private int nEndInv;
    private int nStartInv;
    private ArrayList<Item> itemsSold;

    public RegularVM(){
    }

    public void printSummary(){
        for(Item itemName : itemSold){
            System.out.println(itemName.getItemName())
        }
        System.out.println("Starting Inventory: " + nStartInv);
        System.out.println("Ending Inventory: " + nEndInv);
        System.out.println("Total Sales: " + dSales);
    }

    public int getEndingInventory(){
        return nEndInventory;
    }
    
    public double getSales(){
        return dSales;
    }

    
}
