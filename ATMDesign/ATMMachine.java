package ATMDesign;

import java.util.Map;

public class ATMMachine {
    private final CashInventory cashInventory;
    private final BankService bankService;
    private final TransactionStrategyFactory transactionStrategyFactory;

    private ATMState currentState;
    private Card currentCard;
    private Account authenticatedAccount;
    private TransactionType selectedTransactionType;
    private Integer pendingAmount;

    public ATMMachine(Map<Integer, Integer> initialCashInventory, BankService bankService) {
        this.cashInventory = new CashInventory(initialCashInventory);
        this.bankService = bankService;
        this.transactionStrategyFactory = new TransactionStrategyFactory();
        this.currentState = new IdleState();
    }

    public void insertCard(Card card) {
        currentState.insertCard(this, card);
    }

    public void enterPin(int pin) {
        currentState.enterPin(this, pin);
    }

    public void selectTransaction(TransactionType transactionType) {
        currentState.selectTransaction(this, transactionType);
    }

    public void enterAmount(int amount) {
        currentState.enterAmount(this, amount);
    }

    public void process() {
        currentState.process(this);
    }

    public void ejectCard() {
        currentState.ejectCard(this);
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setState(ATMState currentState) {
        this.currentState = currentState;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public Account getAuthenticatedAccount() {
        return authenticatedAccount;
    }

    public void setAuthenticatedAccount(Account authenticatedAccount) {
        this.authenticatedAccount = authenticatedAccount;
    }

    public TransactionType getSelectedTransactionType() {
        return selectedTransactionType;
    }

    public void setSelectedTransactionType(TransactionType selectedTransactionType) {
        this.selectedTransactionType = selectedTransactionType;
    }

    public Integer getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(Integer pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public CashInventory getCashInventory() {
        return cashInventory;
    }

    public BankService getBankService() {
        return bankService;
    }

    public ITransactionStrategy getTransactionStrategy() {
        if (selectedTransactionType == null) {
            throw new IllegalStateException("No transaction selected.");
        }
        return transactionStrategyFactory.getTransactionStrategy(selectedTransactionType);
    }

    public void resetSession() {
        this.currentCard = null;
        this.authenticatedAccount = null;
        this.selectedTransactionType = null;
        this.pendingAmount = null;
        this.currentState = new IdleState();
    }
}