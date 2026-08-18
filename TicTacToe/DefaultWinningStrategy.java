package TicTacToe;

public class DefaultWinningStrategy implements IWinningStrategy {

    @Override
    public boolean hasWinner(Board board, SlotType symbol) {
        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            boolean rowMatch = true;
            boolean colMatch = true;

            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j) != symbol) {
                    rowMatch = false;
                }
                if (board.getCell(j, i) != symbol) {
                    colMatch = false;
                }
            }

            if (rowMatch || colMatch) {
                return true;
            }
        }

        boolean mainDiagonal = true;
        boolean antiDiagonal = true;

        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i) != symbol) {
                mainDiagonal = false;
            }
            if (board.getCell(i, size - 1 - i) != symbol) {
                antiDiagonal = false;
            }
        }

        return mainDiagonal || antiDiagonal;
    }
}