public class testrun {
    public static void main(String[] args) {
        Item drink = new Item("Rum", 25.00);
        Topping top = new Topping("Mint", 3.00);
        
        Inventory inv = new Inventory(drink, 5);
        inv.restockProduct(drink, 15);
        inv.restockProduct(top, 6);
        inv.restockProduct(top, 4);
        inv.reduceProduct(top, 7);
        inv.reduceProduct(drink, 5);
        inv.addProduct(drink, 3);
        
        Denomination denom = new Denomination(100.00);
        CashRegister reg = new CashRegister(denom, 50);
        reg.addMoney(denom, 5);
        reg.subtractMoney(denom, 10);
        reg.collectPayment(denom, 45);
        System.out.println(denom.getDenomination());
        System.out.println(reg.getRegister());

        System.out.println(drink.getName() + " " + drink.getPrice());
        System.out.println(top.getName() + " " + top.getPrice());
        inv.displayInventory();
    }
}
