package VendingMachine;

import java.util.*;

public class IdleState implements VendingMachineState {
    @Override
    public void setIdleState(VendingMachine vendingMachine) {
        System.out.println("Vending machine is already in idle state.");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int productId) {
        vendingMachine.setSelectedProduct(productId);
        vendingMachine.setCurrentState(new CoinInsertState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Integer> amount) {
        System.out.println("First select the product to checkout");
    }

    @Override
    public void confirmPayment(VendingMachine vendingMachine) {
        System.out.println("Select product first");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Please insert a coin and select a product before dispensing.");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("No change to return. Please insert a coin first.");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("No active transaction to cancel.");
    }
}
