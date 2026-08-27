package ATMDesign;

public class PinEnteredState implements ATMState {
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
        atm.setSelectedTransactionType(transactionType);
        System.out.println("Selected transaction: " + transactionType);
        if (transactionType.requiresAmount()) {
            atm.setState(new AmountSelectionState());
            System.out.println("Please enter amount.");
            return;
        }

        atm.setState(new TransactionExecutionState());
        atm.process();
    }

    @Override
    public void enterAmount(ATMMachine atm, int amount) {
        System.out.println("Please select a transaction first.");
    }

    @Override
    public void process(ATMMachine atm) {
        System.out.println("Please select a transaction first.");
    }

    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("Card ejected.");
        atm.resetSession();
    }
}