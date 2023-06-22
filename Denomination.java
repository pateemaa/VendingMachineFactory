public class Denomination {
    
    private String sDenomination;
    private int nDenomQty;

    public Denomination(String sDenomination, int nDenomQty){
        this.sDenomination = sDenomination;
        this.nDenomQty = nDenomQty;
    }

    public void setDenomQuantity(String sDenomination, int nQty){
        switch(sDenomination){
            case "0.01": nDenomQty = nQty;
            case "0.05": nDenomQty = nQty;
            case "0.10": nDenomQty = nQty;
            case "0.25": nDenomQty = nQty;
            case "1":    nDenomQty = nQty;
            case "5":    nDenomQty = nQty;
            case "10":   nDenomQty = nQty;
            case "20":   nDenomQty = nQty;
            case "50":   nDenomQty = nQty;
            case "100":  nDenomQty = nQty;
            case "200":  nDenomQty = nQty;
            case "500":  nDenomQty = nQty;
            case "1000": nDenomQty = nQty;
        }
    }

    public String getDenomination(){
        return sDenomination;
    }

    public int getQuantity(){
        return nDenomQty;
    }
}
