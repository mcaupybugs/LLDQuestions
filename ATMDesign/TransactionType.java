package ATMDesign;

public enum TransactionType {
    WITHDRAWAL(true),
    DEPOSIT(true),
    BALANCE_INQUIRY(false);

    private final boolean requiresAmount;

    TransactionType(boolean requiresAmount) {
        this.requiresAmount = requiresAmount;
    }

    public boolean requiresAmount() {
        return requiresAmount;
    }
}