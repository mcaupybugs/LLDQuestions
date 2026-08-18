package TicTacToe;

public class Board {
    private final Slot[][] slots;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.slots = new Slot[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                slots[row][col] = new Slot(SlotType.EMPTY);
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size
                && col >= 0 && col < size
                && slots[row][col].slotType == SlotType.EMPTY;
    }

    public boolean placeMove(int row, int col, SlotType slotType) {
        if (!isValidMove(row, col)) {
            return false;
        }
        slots[row][col].slotType = slotType;
        return true;
    }

    public boolean hasWinner(SlotType slotType) {
        for (int i = 0; i < size; i++) {
            boolean rowMatch = true;
            boolean colMatch = true;
            for (int j = 0; j < size; j++) {
                if (slots[i][j].slotType != slotType) {
                    rowMatch = false;
                }
                if (slots[j][i].slotType != slotType) {
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
            if (slots[i][i].slotType != slotType) {
                mainDiagonal = false;
            }
            if (slots[i][size - 1 - i].slotType != slotType) {
                antiDiagonal = false;
            }
        }

        return mainDiagonal || antiDiagonal;
    }

    public void printBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(slots[row][col].slotType + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (slots[row][col].slotType == SlotType.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }
}
