package VendingMachine;

import java.util.List;

public class ReturnChangeState implements VendingMachineState {

    @Override
    public void setIdleState(VendingMachine vendingMachine) {
        vendingMachine.setCurrentState(new IdleState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int productId) {
        System.out.println("Returning change. Please wait.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Integer> coins) {
        System.out.println("Returning change. Cannot accept coins now.");
    }

    @Override
    public void confirmPayment(VendingMachine vendingMachine) {
        System.out.println("Returning change. Payment already completed.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Product already dispensed.");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        vendingMachine.performReturnChange();
        vendingMachine.setCurrentState(new IdleState());
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("Cannot cancel while returning change.");
    }

}
