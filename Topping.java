public class Topping extends Product {

    public Topping(String sTopping, double dPrice) {

        super(sTopping, dPrice);
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
