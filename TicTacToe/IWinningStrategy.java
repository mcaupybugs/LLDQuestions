package TicTacToe;

public interface IWinningStrategy {
    boolean hasWinner(Board board, SlotType slotType);
}