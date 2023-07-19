public abstract class Product {

    private String sName;
    private double dPrice;

    public Product(String sName, double dPrice) {
        this.sName = sName;
        this.dPrice = dPrice;
    }

    public String getName() {
        return sName;
    }

    public void setPrice(String sName) {
        if(sName.equals("Negroni"))
            dPrice = 90.00; 
        else if(sName.equals("Daiquiri"))
            dPrice = 70.00;   
        else if(sName.equals("Dry Martini"))
            dPrice = 65.00;  
        else if(sName.equals("Margarita"))
            dPrice = 85.00;  
        else if(sName.equals("Espresso Martini"))
            dPrice = 50.00;  
        else if(sName.equals("Whiskey Sour"))
            dPrice = 95.00;  
        else if(sName.equals("Manhattan"))
            dPrice = 50.00;  
        else if(sName.equals("Aperol Spritz"))
            dPrice = 68.00;  
        else if(sName.equals("Mojito"))
            dPrice = 110.00;  
        else if(sName.equals("Bloody Mary"))
            dPrice = 100.00;  
        else if(sName.equals("Campari"))
            dPrice = 75.00;  
        else if(sName.equals("Moscow Mule"))
            dPrice = 60.00;  
        else if(sName.equals("Gimlet"))
            dPrice = 115.00;  
        else if(sName.equals("Boulevardier"))
            dPrice = 200.00;  
        else if(sName.equals("Mai Tai"))
            dPrice = 105.00;  
        else 
            dPrice = 0.00;                                                                                                      
    }

    public double getPrice() {
        return dPrice;
    }
}
