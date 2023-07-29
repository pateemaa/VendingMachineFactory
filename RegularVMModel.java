import java.util.*;

public class RegularVMModel {
    
    private ArrayList<Item> drinks;
    private ArrayList<Denomination> cash;
    private ArrayList<Denomination> payment;

    public RegularVMModel(){
        drinks = new ArrayList<>();
        cash = new ArrayList<>();
        payment = new ArrayList<>();
    }

    public void populateItems(){
        drinks.add(new Item("Rum", 50.00));
        drinks.add(new Item("Lime Juice", 40.00));
        drinks.add(new Item("Soda Water", 25.00));
        drinks.add(new Item("Gin", 65.00));
        drinks.add(new Item("Tonic", 85.00));
        drinks.add(new Item("Tequila", 90));
        drinks.add(new Item("Whiskey", 55));
        drinks.add(new Item("Orange Juice", 20.00));
        drinks.add(new Item("Vodka", 65.00));
        drinks.add(new Item("Vermouth", 70.00));
    }

    public void populateRegister(){
        cash.add(new Denomination(1.00));
        cash.add(new Denomination(5.00));
        cash.add(new Denomination(10.00));
        cash.add(new Denomination(20.00));
        cash.add(new Denomination(50.00));
        cash.add(new Denomination(100.00));
        cash.add(new Denomination(200.00));
        cash.add(new Denomination(500.00));
        cash.add(new Denomination(1000.00));
    }

    public boolean matchDenomination(double den) {
        boolean isValid = false;
        for (Denomination denomination : cash) {
            if (denomination.getDenomination() == den) {
                payment.add(denomination);
                isValid = true;
            }
        }
        return isValid;
    }

    public ArrayList<Denomination> getPayment(){
        return payment;
    }

    public ArrayList<Item> getItems(){
        return this.drinks;
    }

    public ArrayList<Denomination> getCashRegister(){
        return this.cash;
    }
}
