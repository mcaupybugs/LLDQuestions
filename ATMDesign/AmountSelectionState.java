package ATMDesign;

public class AmountSelectionState implements ATMState {
    @Override
    public void insertCard(ATMMachine atm, Card card) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void enterPin(ATMMachine atm, int pin) {
        System.out.println("PIN already entered.");
    }

    @Override
    public void selectTransaction(ATMMachine atm, TransactionType transactionType) {
        System.out.println("Transaction already selected. Please enter amount.");
    }

    @Override
    public void enterAmount(ATMMachine atm, int amount) {
        if (amount <= 0) {
            System.out.println("Amount should be greater than zero.");
            return;
        }

        atm.setPendingAmount(amount);
        atm.setState(new TransactionExecutionState());
        atm.process();
    }

    @Override
    public void process(ATMMachine atm) {
        System.out.println("Please enter amount first.");
    }

    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("Card ejected.");
        atm.resetSession();
    }
}
