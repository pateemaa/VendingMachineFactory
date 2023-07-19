public class SpecialVM {
    
    public SpecialVM(){

    }

    public void mixAndMatch(Product item1, Product item2, Product top1){ 
        double dCost;

        dCost = item1.getPrice() + item2.getPrice() + top1.getPrice();

        System.out.println("Pouring " + item1 + "...");
        System.out.println("Pouring " + item2 + "...");
        System.out.println("Mixing drink...");
        System.out.println("Garnishing with" + top1 + "...");
        System.out.println("Done, enjoy!");
    }

    public void mixAndMatch(Product item1, Product item2, Product item3, Product top1, Product top2){ 
        double dCost;

        dCost = item1.getPrice() + item2.getPrice() + top1.getPrice() + top1.getPrice() + top2.getPrice();

        System.out.println("Pouring " + item1 + "...");
        System.out.println("Pouring " + item2 + "...");
        System.out.println("Pouring " + item3 + "...");
        System.out.println("Mixing drink...");
        System.out.println("Garnishing with" + top1 + "...");
        System.out.println("Garnishing with" + top2 + "...");
        System.out.println("Done, enjoy!");
    }
}
