package VendingMachine;

import java.util.List;

public class DispenseProductState implements VendingMachineState {

    @Override
    public void setIdleState(VendingMachine vendingMachine) {
        vendingMachine.setCurrentState(new IdleState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int productId) {
        System.out.println("Dispense in progress. Please wait.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Integer> coins) {
        System.out.println("Dispense in progress. Cannot accept more coins.");
    }

    @Override
    public void confirmPayment(VendingMachine vendingMachine) {
        System.out.println("Payment already confirmed.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        vendingMachine.performDispense();
        vendingMachine.setCurrentState(new ReturnChangeState());
        vendingMachine.getCurrentState().returnChange(vendingMachine);
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("Dispensing product before returning change.");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("Cannot cancel while product is being dispensed.");
    }

}
