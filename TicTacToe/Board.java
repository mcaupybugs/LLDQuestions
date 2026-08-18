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
                && slots[row][col].isEmpty();
    }

    public boolean placeMove(int row, int col, SlotType slotType) {
        if (!isValidMove(row, col)) {
            return false;
        }
        slots[row][col].setSymbol(slotType);
        return true;
    }

    public void printBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(slots[row][col].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public SlotType getCell(int row, int col) {
        return slots[row][col].getSymbol();
    }

    public boolean isFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (slots[row][col].isEmpty()) {
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
