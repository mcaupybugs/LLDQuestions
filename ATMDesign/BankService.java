package ATMDesign;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    private final Map<String, Account> accountsByCardNumber;

    public BankService(Map<String, Account> accountsByCardNumber) {
        this.accountsByCardNumber = new HashMap<>(accountsByCardNumber);
    }

    public Account authenticate(String cardNumber, int pin) {
        Account account = accountsByCardNumber.get(cardNumber);
        if (account == null || account.getPin() != pin) {
            return null;
        }
        return account;
    }

    public void deposit(String accountNumber, int amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(String accountNumber, int amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        account.withdraw(amount);
    }

    public int getBalance(String accountNumber) {
        return getAccountByAccountNumber(accountNumber).getBalance();
    }

    private Account getAccountByAccountNumber(String accountNumber) {
        return accountsByCardNumber.values()
                .stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountNumber));
    }
}