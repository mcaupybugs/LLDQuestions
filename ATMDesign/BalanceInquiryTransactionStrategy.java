package ATMDesign;

public class BalanceInquiryTransactionStrategy implements ITransactionStrategy {
    @Override
    public void execute(ATMMachine atm, Integer amount) {
        Account account = atm.getAuthenticatedAccount();
        if (account == null) {
            throw new IllegalStateException("No authenticated account found.");
        }

        System.out.println("Available balance: " + account.getBalance());
    }
}