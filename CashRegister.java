import java.util.*;

public class CashRegister{
    private Map<Denomination, Integer> register;
    private double dTotalCost;

    public CashRegister(Denomination denom, int nDenomQty){
        register = new HashMap<>();
        register.put(denom, nDenomQty);
    }

    public Map<Denomination, Integer> getRegister(){
        return register;
    } 

    public void addMoney(Denomination denom, int nDenomQty){
        int nCurrQty, nNewQty;

        if(register.containsKey(denom)){
            nCurrQty = register.get(denom);
            nNewQty = nCurrQty + nDenomQty;

            if(nNewQty >= 0){
                register.put(denom, nNewQty);
            }else{
                System.out.println("Invalid quantity");
            }
        }else{
            System.out.println("Invalid denomination");
        }
    }

    public void subtractMoney(Denomination denom, int nDenomQty){
        int nCurrQty, nNewQty;

        if(register.containsKey(denom)){
            nCurrQty = register.get(denom);
            nNewQty = nCurrQty - nDenomQty;

            if(nNewQty >= 0){
                register.put(denom, nNewQty);
            }else{
                System.out.println("Invalid quantity");
            }
        }else{
            System.out.println("Invalid denomination");
        }
    }

    public void calculateTotalCost(Item item){
        dTotalCost = item.getPrice();
    }

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

    public double getTotalCost(){
        return dTotalCost;
    }

    public void receivePayment(ArrayList<Denomination> denomList, ArrayList<Integer> nDenomQtyList){
        double dPayment = 0.00; 
        ArrayList<Double> dDenomination = new ArrayList<>();
        Denomination d;
        int i;

        for(i=0; i<denomList.size(); i++){
            d = denomList.get(i);
            dDenomination.add(d.getDenomination());
            dPayment += d.getDenomination()*nDenomQtyList.get(i);
        }

        if(dPayment >= dTotalCost){
            for(i=0; i<denomList.size(); i++){
                addMoney(denomList.get(i), nDenomQtyList.get(i));
            }
            System.out.println("Payment made successfully");
        }else{
            System.out.println("Error: Payment not enough");
        }
    }

    public void collectPayment(Denomination denom, int nDenomQty){
        subtractMoney(denom, nDenomQty);
    }

    public double calculateChange(double dPayment, double dPrice){
        double dChange;
        dChange = dPayment - dPrice;

        return dChange;
    }

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

    public HashMap<Denomination, Integer> countDenomination(double dMoney){
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

    public boolean produceChange(double dChange){
        HashMap<Denomination, Integer> cash;
        Denomination denom;
        int nEntryQty;
        cash = countDenomination(dChange);
        
        if(isChangeEnough(dChange)){
            for(Map.Entry<Denomination, Integer> entry : cash.entrySet()){
                denom = entry.getKey();
                nEntryQty = entry.getValue();
                subtractMoney(denom, nEntryQty);
            }
            return true;
        }else{
           return false;
        }
    }
}
