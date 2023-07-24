public class Denomination{
    private double dValue;

    public Denomination(double dValue){
        this.dValue = dValue;
    }

    public double getDenomination(){
        return dValue;
    }

    public String toString(){
        return String.format("%.2f",dValue);
    }
    
}