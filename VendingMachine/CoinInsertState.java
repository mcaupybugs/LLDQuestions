package VendingMachine;

import java.util.*;

public class CoinInsertState implements VendingMachineState {
    @Override
    public void setIdleState(VendingMachine vendingMachine) {
        System.out.println("Vending machine is already in idle state.");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int productId) {
        System.out.println("Selected product already, insert coin now");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Integer> coins) {
        vendingMachine.addInsertedCoins(coins);
    }

    @Override
    public void confirmPayment(VendingMachine vendingMachine) {
        if (!vendingMachine.hasSufficientFunds()) {
            System.out.println("Insufficient funds. Please insert more coins.");
            return;
        }

        if (!vendingMachine.canReturnChange()) {
            System.out.println("Change not available. cancelling transaction");
            vendingMachine.performCancelTransaction();
            vendingMachine.setCurrentState(new IdleState());
            return;
        }

        vendingMachine.setCurrentState(new DispenseProductState());
        vendingMachine.dispenseProduct();
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
        vendingMachine.performCancelTransaction();
        vendingMachine.setCurrentState(new IdleState());
    }
}
