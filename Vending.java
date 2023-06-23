public class Vending {

    private double dChange;
    
    public void dispenseItem(Item q){
        if(q.getItemQuantity() > 0){
            q.setQuantity(q.getItemName(), q.getItemQuantity() - 1);
            System.out.println("Dispensing " + q.getItemName() + "...");
        }
    }

    public void receivePayment(){
         
    }

    public void produceChange(){
    
    }
}
