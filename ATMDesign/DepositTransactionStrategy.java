package ATMDesign;

public class DepositTransactionStrategy implements ITransactionStrategy {
    @Override
    public void execute(ATMMachine atm, Integer amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("A valid deposit amount is required.");
        }

        Account account = atm.getAuthenticatedAccount();
        if (account == null) {
            throw new IllegalStateException("No authenticated account found.");
        }

        atm.getBankService().deposit(account.getAccountNumber(), amount);
        System.out.println("Deposited amount: " + amount);
        System.out.println("Updated account balance: " + account.getBalance());
    }
}