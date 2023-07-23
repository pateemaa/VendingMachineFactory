import java.util.*;

public class CashRegister{
    private Map<Denomination, Integer> register;

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

    public void receivePayment(Denomination denom, int nDenomQty){
        double dPrice, dPayment, dDenomination;

        dDenomination = denom.getDenomination();
        dPrice = Product.getPrice();

        dPayment = dDenomination*nDenomQty;

        if(dPayment >= dPrice){
            addMoney(denom, nDenomQty);
            System.out.println("Payment made successfully");
        }else{
            System.out.println("Error: Payment not enough");
        }
    }

    public void receivePayment(Denomination denom1, Denomination denom2, int nDenomQty1, int nDenomQty2){
        double dPrice, dPayment; 
        ArrayList<Double> dDenomination;

        dDenomination.add(denom1.getDenomination());
        dDenomination.add(denom2.getDenomination());
        dPrice = Item.getPrice();

        dPayment = Double.sum((dDenomination.get(0)*nDenomQty1), (dDenomination.get(1)*nDenomQty2));

        if(dPayment >= dPrice){
            addMoney(denom1, nDenomQty1);
            addMoney(denom2, nDenomQty2);
            System.out.println("Payment made successfully");
        }else{
            System.out.println("Error: Payment not enough");
        }
    }

    public void receivePayment(ArrayList<Denomination> denomList, ArrayList<Integer> nDenomQtyList){
        double dPrice, dPayment; 
        ArrayList<Double> dDenomination;
        Denomination d;
        int i;

        for(i=0; i<denomList.size(); i++){
            dDenomination.add(d.getDenomination());
        }
        
        dPrice = Item.getPrice();

        for(i=0; i<denomList.size(); i++){
            dPayment = Double.sum((dDenomination.get(i)*nDenomQtyList.get(i)), (dDenomination.get(i+1)*nDenomQtyList.get(i+1)));
        }

        if(dPayment >= dPrice){
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
