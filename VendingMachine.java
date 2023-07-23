public class VendingMachine {
    public static void main(String[] args){
        VendingMachineView vmView = new VendingMachineView();
        RegularVMView rgvmView = new RegularVMView();
        SpecialVMView spvmView = new SpecialVMView();


        new VendingMachineController(vmView, rgvmView, spvmView);
    }
}
