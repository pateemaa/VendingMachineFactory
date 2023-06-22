public class Item {
    
    private String sName;
    private int nCalories;
    private int nQuantity;

    public Item(String sName){
        this.sName = sName;
        setCalories(sName);
        setQuantity(sName, nQuantity);
    }

    public void setCalories(String sName){
        switch(sName){
            case "drink1": nCalories = 5;
            case "drink2": nCalories = 5;
            case "drink3": nCalories = 5;
            case "drink4": nCalories = 5;
            case "drink5": nCalories = 5;
            case "drink6": nCalories = 5;
            case "drink7": nCalories = 5;
            case "drink8": nCalories = 5;
        }
    }

    public void setQuantity(String sName, int nQ){
        switch(sName){
            case "drink1": nQuantity = nQ;
            case "drink2": nQuantity = nQ;
            case "drink3": nQuantity = nQ;
            case "drink4": nQuantity = nQ;
            case "drink5": nQuantity = nQ;
            case "drink6": nQuantity = nQ;
            case "drink7": nQuantity = nQ;
            case "drink8": nQuantity = nQ;
        }
    }

    public String getItemName(){
        return sName;
    }
    
    public Integer getItemCalories(){
        return nCalories;
    }

    public Integer getItemQuantity(){
        return nQuantity;
    }
    
}
