public class VendingMachine {
    public static void main(String[] args){
        VendingMachineView vmView = new VendingMachineView();
        RegularVMModel rMod = new RegularVMModel();

        CashRegister cReg = new CashRegister();
        rMod.initializeRegister();

        Inventory inventory = new Inventory();
        rMod.initializeInventory();

        new VendingMachineController(vmView);
    }
}
