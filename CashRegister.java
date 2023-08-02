import java.util.*;

/**
 * CashRegister class contains the attributes and behaviors of a cash register
 */
public class CashRegister{
    private Map<Denomination, Integer> register;
    private double dTotalCost;
    private double dChange;

    /**
     * creates an instance of a cash register
     */
    public CashRegister(){
        register = new HashMap<>();
    }

    /**
     * getter for the register
     * @return the values of the registerm denomination and its quantity
     */
    public Map<Denomination, Integer> getRegister(){
        return register;
    } 

    /**
     * method to add an amount of the denomination
     * @param denom is the denomination
     * @param nDenomQty is the quantity to be added
     */
    public void addMoney(Denomination denom, int nDenomQty){
        int nCurrQty, nNewQty;

        if(register.containsKey(denom)){

            try {
                if(nDenomQty < 0){
                    throw new IllegalArgumentException("Quantity must be a non-negative number");
                }
                nCurrQty = register.get(denom);
                nNewQty = nCurrQty + nDenomQty;
                register.put(denom, nNewQty);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
        }else{
            register.put(new Denomination(denom.getDenomination()), nDenomQty);
        }
    }

    /**
     * subtracts money from the register
     * @param denom is the denomination
     * @param nDenomQty is the quantity to be subtracted
     */
    public void subtractMoney(Denomination denom, int nDenomQty){
        int nCurrQty, nNewQty;

        if(register.containsKey(denom)){

            try {
                if(nDenomQty < 0){
                    throw new IllegalArgumentException("Quantity must be a non-negative number");
                }
                
                nCurrQty = register.get(denom);
                if(nCurrQty < nDenomQty){
                    throw new IllegalArgumentException("Register has insufficient funds");
                }      
                nNewQty = nCurrQty - nDenomQty;
                register.put(denom, nNewQty);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }else{
            System.out.println("Invalid denomination");
        }
    }

    /**
     * calculates the total cost of the items bought by customer
     * @param item is the item bought by the customer
     */
    public void calculateTotalCost(Item item){
        dTotalCost = item.getPrice();
    }

    /**
     * calculates the total cost of the products bought by the customer
     * @param itemList contains the list of items bought by the user
     * @param toppingList contains the list of toppings bought by the user
     */
    public void calculateTotalCost(ArrayList<Item> itemList, ArrayList<Topping> toppingList) {
        double dItemTotal, dTopTotal;

        dItemTotal = 0.00;
        dTopTotal = 0.00;

        for(Item item : itemList){
            dItemTotal += item.getPrice();
        }

        for(Topping topping : toppingList){
            dTopTotal += topping.getPrice();
        }

        dTotalCost = dItemTotal + dTopTotal;

    }

    /**
     * getter for the total cost of products
     * @return the total cost of the products
     */
    public double getTotalCost(){
        return dTotalCost;
    }

    /**
     * receives the payment entered by the user
     * @param dPayment the total payment entered by the user
     */
    public void receivePayment(double dPayment){
        Map<Denomination, Integer> receivedPayment;
        receivedPayment = getDenomBreakdown(dPayment);
        
        for(Map.Entry<Denomination, Integer> entry : receivedPayment.entrySet()){
            addMoney(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Collects the denomination/cash from the register. This method subtracts the amount
     * of cash collected by the manager/owner.
     * @param denom is the denomination chosen by the owner
     * @param nDenomQty is teh amount of bills/coins the owner chooses to collect.
     */
    public void collectPayment(Denomination denom, int nDenomQty){
        subtractMoney(denom, nDenomQty);
    }

    /**
     * Calculates the customer's change
     * @param dPayment is the total payment entered by the customer
     * @param dPrice is the total price of the products bought by the customer
     */
    public void calculateChange(double dPayment, double dPrice){
        dChange = dPayment - dPrice;

    }

    /**
     * getter for the change
     * @return the change
     */
    public double getChange(){
        return dChange;
    }

    /**
     * boolean method to check whether the register contains enough amount of denominations to
     * produce change
     * @param dChange is the change
     * @return a boolean value to confirm whether the register is capable of producing change
     */
    public boolean isChangeEnough(double dChange){
        int nRegisterQty, nQtyNeeded;
        double dDenomValue;

        if(dChange == 0){
            return true;
        }

        for (Denomination denomination : register.keySet()) {
            nRegisterQty = register.getOrDefault(denomination, 0);
            dDenomValue = denomination.getDenomination();
    
            if (dDenomValue <= dChange && nRegisterQty > 0) {
                nQtyNeeded = (int) (dChange / dDenomValue);
                if (nQtyNeeded <= nRegisterQty) {
                    return true;
                }
            }
        }
    
        return false;
    }

    /**
     * produces the denomination breakdown of the total cash entered
     * @param dMoney is the total cash
     * @return a list of denomination and its quantity
     */
    public HashMap<Denomination, Integer> getDenomBreakdown(double dMoney){
        HashMap<Denomination, Integer> cash;
        double dRem, dDenomValue;
        int nRegisterQty, nDenomQty;
        
        dRem = dMoney;
        cash = new HashMap<>();   

        for(Denomination denomination : register.keySet()){
            nRegisterQty = register.getOrDefault(denomination, 0);
            dDenomValue = denomination.getDenomination();

            nDenomQty = (int) (dRem/dDenomValue);
            nDenomQty = Math.min(nDenomQty, nRegisterQty);
            dRem %= dDenomValue;
            cash.put(denomination, nDenomQty);
        }

        return cash;
    }

    /**
     * Method to produce the change. Given the change, it identifies the denomination breakdown
     * and subtracts the quantity from the register
     * @param dChange is the change
     */
    public void produceChange(double dChange){
        HashMap<Denomination, Integer> cash;
        Denomination denom;
        int nEntryQty;
        cash = getDenomBreakdown(dChange);
        
        for(Map.Entry<Denomination, Integer> entry : cash.entrySet()){
            denom = entry.getKey();
            nEntryQty = entry.getValue();
            subtractMoney(denom, nEntryQty);
        }
        
    }
}
