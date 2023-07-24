public abstract class Product {

    protected String sName;
    private double dPrice;

    public Product(String sName, double dPrice) {
        this.sName = sName;
        this.dPrice = dPrice;
    }

    public String getName() {
        return sName;
    }

    public void setPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public double getPrice() {
        return dPrice;
    }
}
