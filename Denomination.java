/**
 * Denomination class contains the attributes and behaviors of a denomination
 */
public class Denomination{
    private double dValue;

    /**
     * creates an instance of a denomination
     * @param dValue is the denomination
     */
    public Denomination(double dValue){
        this.dValue = dValue;
    }

    /**
     * getter for the denomination
     * @return the denomination
     */
    public double getDenomination(){
        return dValue;
    }

    /**
     * method to convert the denomination to a string
     */
    public String toString(){
        return String.format("%.2f",dValue);
    }
    
}