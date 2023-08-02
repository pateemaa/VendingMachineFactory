import java.awt.event.*;

/**
 * This class is the controller for the vending machine
 */
public class VendingMachineController {
    private VendingMachineView vmView;
    private RegularVMModel rvmModel;
    private RegularVMView rvmView;
    private RegularVMController rvmControl;
    private boolean isRvmActive;
    private boolean isSpvmActive;

    /**
     * creates a instance of the vendong machine's controller
     * @param vmView is the view of the vending machine
     */
    public VendingMachineController(VendingMachineView vmView){
        this.vmView = vmView;
        this.isRvmActive = false;
        this.isSpvmActive = false;

        rvmModel = new RegularVMModel();
        rvmView = new RegularVMView();
        rvmControl = new RegularVMController(rvmModel, rvmView);

        this.vmView.setRvmBtnActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                vmView.dispose();
                RegularVMView regView = new RegularVMView();
                regView.setVisible(true);
                isRvmActive = true;
            }
            
        });

        this.vmView.setSpvmBtnActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                vmView.dispose();
                SpecialVMView specView = new SpecialVMView();
                specView.setVisible(true);
                isSpvmActive = true;
            }
            
        });
    }

}
