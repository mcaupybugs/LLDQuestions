package ATMDesign;

public class TransactionExecutionState implements ATMState {
    @Override
    public void insertCard(ATMMachine atm, Card card) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void enterPin(ATMMachine atm, int pin) {
        System.out.println("Transaction is in progress.");
    }

    @Override
    public void selectTransaction(ATMMachine atm, TransactionType transactionType) {
        System.out.println("Transaction is in progress.");
    }

    @Override
    public void enterAmount(ATMMachine atm, int amount) {
        System.out.println("Transaction is in progress.");
    }

    @Override
    public void process(ATMMachine atm) {
        try {
            ITransactionStrategy strategy = atm.getTransactionStrategy();
            strategy.execute(atm, atm.getPendingAmount());
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Card ejected.");
            atm.resetSession();
        }
    }

    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("Cannot eject card while transaction is in progress.");
    }
}
