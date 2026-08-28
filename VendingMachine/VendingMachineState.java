package VendingMachine;

import java.util.*;

public interface VendingMachineState {
    void setIdleState(VendingMachine vendingMachine);

    void selectProduct(VendingMachine vendingMachine, int productId);

    void insertCoin(VendingMachine vendingMachine, List<Integer> coins);

    void confirmPayment(VendingMachine vendingMachine);

    void dispenseProduct(VendingMachine vendingMachine);

    void returnChange(VendingMachine vendingMachine);

    void cancelTransaction(VendingMachine vendingMachine);
}
