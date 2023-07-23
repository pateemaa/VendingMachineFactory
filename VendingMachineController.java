import java.awt.event.*;

public class VendingMachineController {
    private final VendingMachineView vmView;
    private final RegularVMView rvmView;
    private final SpecialVMView spView;

    public VendingMachineController(VendingMachineView vmView, RegularVMView rvmView, SpecialVMView spView){
        this.vmView = vmView;
        this.rvmView = rvmView;
        this.spView = spView;

        this.vmView.setRvmBtnActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                vmView.dispose();
                RegularVMView newRvmView = new RegularVMView();
                newRvmView.setVisible(true);
            }
            
        });

        this.vmView.setSpvmBtnActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                vmView.dispose();
                SpecialVMView newSpView = new SpecialVMView();
                newSpView.setVisible(true);
            }
            
        });
    }

}
