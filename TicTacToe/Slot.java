package TicTacToe;

enum SlotType {
    X,
    O,
    EMPTY
};

public class Slot {
    private SlotType slotType;

    public Slot(SlotType slotType) {
        this.slotType = slotType;
    }

    public boolean hasSymbol(SlotType symbol) {
        return this.slotType == symbol;
    }

    public boolean isEmpty() {
        return slotType == SlotType.EMPTY;
    }

    public void setSymbol(SlotType symbol) {
        this.slotType = symbol;
    }

    public SlotType getSymbol() {
        return slotType;
    }
}
