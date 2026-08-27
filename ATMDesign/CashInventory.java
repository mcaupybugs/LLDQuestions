package ATMDesign;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CashInventory {
    private final Map<Integer, Integer> notesByDenomination;
    private static final List<Integer> SUPPORTED_DENOMINATIONS = List.of(100, 50, 20, 10);

    public CashInventory(Map<Integer, Integer> initialInventory) {
        this.notesByDenomination = new LinkedHashMap<>();
        for (Integer denomination : SUPPORTED_DENOMINATIONS) {
            notesByDenomination.put(denomination, initialInventory.getOrDefault(denomination, 0));
        }
    }

    public Map<Integer, Integer> previewDispense(int amount) {
        validateAmount(amount);
        int remaining = amount;
        Map<Integer, Integer> plan = new LinkedHashMap<>();

        for (Integer denomination : SUPPORTED_DENOMINATIONS) {
            int availableNotes = notesByDenomination.getOrDefault(denomination, 0);
            int notesToUse = Math.min(remaining / denomination, availableNotes);
            if (notesToUse > 0) {
                plan.put(denomination, notesToUse);
                remaining -= denomination * notesToUse;
            }
        }

        if (remaining != 0) {
            throw new IllegalArgumentException("Requested amount cannot be dispensed exactly with available denominations.");
        }

        return plan;
    }

    public Map<Integer, Integer> dispense(int amount) {
        Map<Integer, Integer> plan = previewDispense(amount);
        for (Map.Entry<Integer, Integer> entry : plan.entrySet()) {
            Integer denomination = entry.getKey();
            Integer count = entry.getValue();
            notesByDenomination.put(denomination, notesByDenomination.get(denomination) - count);
        }
        return plan;
    }

    public int getTotalCash() {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : notesByDenomination.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }
        return total;
    }

    public Map<Integer, Integer> snapshot() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(notesByDenomination));
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be greater than zero.");
        }
        if (amount % 10 != 0) {
            throw new IllegalArgumentException("Amount should be in multiples of 10.");
        }
        if (getTotalCash() < amount) {
            throw new IllegalArgumentException("ATM has insufficient cash.");
        }
    }
}