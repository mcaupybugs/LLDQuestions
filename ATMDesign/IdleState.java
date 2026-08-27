package ATMDesign;

public class IdleState implements ATMState {
    @Override
    public void insertCard(ATMMachine atm, Card card) {
        atm.setCurrentCard(card);
        System.out.println("Card inserted. Please enter your PIN.");
        atm.setState(new CardInsertedState());
    }

    @Override
    public void enterPin(ATMMachine atm, int pin) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void selectTransaction(ATMMachine atm, TransactionType transactionType) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void enterAmount(ATMMachine atm, int amount) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void process(ATMMachine atm) {
        System.out.println("No transaction to process. Please insert your card first.");
    }

    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("No card to eject.");
    }
}