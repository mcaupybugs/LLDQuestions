package ATMDesign;

public interface ATMState {
    void insertCard(ATMMachine atm, Card card);
    void enterPin(ATMMachine atm, int pin);
    void selectTransaction(ATMMachine atm, TransactionType transactionType);
    void enterAmount(ATMMachine atm, int amount);
    void process(ATMMachine atm);
    void ejectCard(ATMMachine atm);
}