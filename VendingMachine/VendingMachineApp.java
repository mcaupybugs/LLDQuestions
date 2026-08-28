package VendingMachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineApp {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(createProducts(), createCoins());

        runSuccessfulPurchaseScenario(vendingMachine);
        runCancelledTransactionScenario(vendingMachine);
    }

    private static Map<Integer, Product> createProducts() {
        Map<Integer, Product> products = new HashMap<>();
        products.put(1, new Product(1, "Cola", 5, 10));
        products.put(2, new Product(2, "Chips", 3, 15));
        products.put(3, new Product(3, "Water", 4, 5));
        return products;
    }

    private static Map<Integer, Integer> createCoins() {
        Map<Integer, Integer> coins = new HashMap<>();
        coins.put(1, 10);
        coins.put(5, 10);
        coins.put(10, 10);
        return coins;
    }

    private static void runSuccessfulPurchaseScenario(VendingMachine vendingMachine) {
        System.out.println("Successful purchase scenario");
        vendingMachine.selectProduct(2);
        vendingMachine.insertCoins(Arrays.asList(10, 5));
        vendingMachine.confirmPayment();
        System.out.println("Scenario complete\n");
    }

    private static void runCancelledTransactionScenario(VendingMachine vendingMachine) {
        System.out.println("Cancelled transaction scenario");
        vendingMachine.selectProduct(1);
        vendingMachine.insertCoins(Arrays.asList(5));
        vendingMachine.cancelTransaction();
        System.out.println("Scenario complete");
    }
}