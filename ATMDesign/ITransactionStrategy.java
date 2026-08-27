package ATMDesign;

public interface ITransactionStrategy {
    void execute(ATMMachine atm, Integer amount);
}