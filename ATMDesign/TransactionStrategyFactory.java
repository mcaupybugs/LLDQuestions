package ATMDesign;

public class TransactionStrategyFactory {
    public ITransactionStrategy getTransactionStrategy(TransactionType transactionType) {
        return switch (transactionType) {
            case DEPOSIT -> new DepositTransactionStrategy();
            case WITHDRAWAL -> new WithdrawalTransactionStrategy();
            case BALANCE_INQUIRY -> new BalanceInquiryTransactionStrategy();
        };
    }
}