package ATMDesign;

public class Account {
    private final String accountNumber;
    private final int pin;
    private int balance;

    public Account(String accountNumber, int pin, int balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient account balance.");
        }
        this.balance -= amount;
    }
}