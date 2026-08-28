package VendingMachine;

import java.util.*;

public class CoinInventoryService {
    private Map<Integer, Integer> cashInventory;

    public CoinInventoryService(Map<Integer, Integer> cash) {
        this.cashInventory = cash;
    }

    public void addCoins(List<Integer> coins) {
        for (Integer coin : coins) {
            cashInventory.merge(coin, 1, Integer::sum);
        }
    }

    public boolean findChangeAvailable(Integer amount) {
        if (amount < 0) {
            return false;
        }

        int remaining = amount;
        List<Integer> denominations = new ArrayList<>(cashInventory.keySet());
        denominations.sort(Collections.reverseOrder());

        for (Integer denomination : denominations) {
            int available = cashInventory.getOrDefault(denomination, 0);
            while (available > 0 && remaining >= denomination) {
                remaining -= denomination;
                available--;
            }
        }

        return remaining == 0;
    }

    public void returnChange(Integer amount) {
        if (amount <= 0) {
            return;
        }

        int remaining = amount;
        List<Integer> denominations = new ArrayList<>(cashInventory.keySet());
        denominations.sort(Collections.reverseOrder());

        for (Integer denomination : denominations) {
            int available = cashInventory.getOrDefault(denomination, 0);
            while (available > 0 && remaining >= denomination) {
                remaining -= denomination;
                available--;
                cashInventory.put(denomination, available);
            }
        }

        if (remaining != 0) {
            throw new IllegalStateException("Unable to return exact change");
        }
    }
}
