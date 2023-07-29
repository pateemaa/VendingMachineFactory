import java.awt.event.*;

public class VendingMachineController {
    private final VendingMachineView vmView;
    private final RegularVMView rvmView;
    private final SpecialVMView spView;
    private RegularVMModel rvmModel;

    public VendingMachineController(VendingMachineView vmView, RegularVMView rvmView, SpecialVMView spView){
        this.vmView = vmView;
        this.rvmView = rvmView;
        this.spView = spView;

        this.vmView.setRvmBtnActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                vmView.dispose();
                RegularVMView regView = new RegularVMView();
                regView.setVisible(true);
            }
            
        });

        this.vmView.setSpvmBtnActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                vmView.dispose();
                SpecialVMView specView = new SpecialVMView();
                specView.setVisible(true);
            }
            
        });

        this.rvmView.setAddBtnActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cashList = " ";
                double den = rvmView.getDenomListSelectedItem();
                rvmModel.matchDenomination(den);
                

                for(Denomination denomination : rvmModel.getPayment()){
                    cashList += rvmView.getCashSliderValue() + " " + denomination.getDenomination();
                }

                rvmView.setDisplayTextArea(cashList);
            }
            
        });
    }

}
