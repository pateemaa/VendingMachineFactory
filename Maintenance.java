public class Maintenance {
    private double dPrice;
    private int nRestock;
    private int nReplenish;

    public void setPrice(Item sName){
        if(sName.equals("drink1")){
            dPrice = 0;
        }else if(sName.equals("drink2")){
            dPrice = 0;
        }else if(sName.equals("drink3")){
            dPrice = 0;
        }else if(sName.equals("drink4")){
            dPrice = 0;
        }else if(sName.equals("drink5")){
            dPrice = 0;
        }else if(sName.equals("drink6")){
            dPrice = 0;
        }else if(sName.equals("drink7")){
            dPrice = 0;
        }else if(sName.equals("drink8")){
            dPrice = 0;
        }
    }

    public void restockItem(Item item){
        if(item.getItemQuantity() == 10){
            System.out.println("Item does not need restocking");
        }else{
            nRestock = 10 - item.getItemQuantity();
            item.setQuantity(item.getItemName(), item.getItemQuantity() + nRestock);
        }
    }
    
    public void replenishMoney(Denomination denom){
        if(denom.getQuantity() < 100){
            nReplenish = 100 - denom.getQuantity();
            denom.setDenomQuantity(denom.getDenomination(), denom.getQuantity() + nReplenish);
        }
    }
}
