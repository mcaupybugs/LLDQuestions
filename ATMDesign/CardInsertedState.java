package ATMDesign;

public class CardInsertedState implements ATMState {
    @Override
    public void insertCard(ATMMachine atm, Card card) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void enterPin(ATMMachine atm, int pin) {
        Card card = atm.getCurrentCard();
        if (card == null) {
            System.out.println("No card found. Resetting session.");
            atm.resetSession();
            return;
        }

        Account account = atm.getBankService().authenticate(card.getCardNumber(), pin);
        if (account == null) {
            System.out.println("Invalid PIN. Card ejected.");
            atm.resetSession();
            return;
        }

        atm.setAuthenticatedAccount(account);
        System.out.println("PIN verified. Please select a transaction.");
        atm.setState(new PinEnteredState());
    }

    @Override
    public void selectTransaction(ATMMachine atm, TransactionType transactionType) {
        System.out.println("Please enter your PIN first.");
    }

    @Override
    public void enterAmount(ATMMachine atm, int amount) {
        System.out.println("Please enter your PIN first.");
    }

    @Override
    public void process(ATMMachine atm) {
        System.out.println("Please enter your PIN first.");
    }

    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("Card ejected.");
        atm.resetSession();
    }
}