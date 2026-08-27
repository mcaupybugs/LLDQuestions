package ATMDesign;

import java.util.Map;

public class WithdrawalTransactionStrategy implements ITransactionStrategy {
    @Override
    public void execute(ATMMachine atm, Integer amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("A valid withdrawal amount is required.");
        }

        Account account = atm.getAuthenticatedAccount();
        if (account == null) {
            throw new IllegalStateException("No authenticated account found.");
        }

        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient account balance.");
        }

        Map<Integer, Integer> notesToDispense = atm.getCashInventory().previewDispense(amount);
        atm.getBankService().withdraw(account.getAccountNumber(), amount);
        atm.getCashInventory().dispense(amount);
        System.out.println("Please collect your cash: " + notesToDispense);
        System.out.println("Remaining account balance: " + account.getBalance());
    }
}