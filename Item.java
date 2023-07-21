public class Item extends Product {

    public Item(String sName, double dPrice) {
        
        super(sName, dPrice);
    }

    @Override
    public void setPrice(double dPrice) {
        
        if (dPrice > 0) {
            super.setPrice(dPrice);
        } 
        
        else {
            System.out.println("Error! Invalid Price Input");
        }
    }

}
