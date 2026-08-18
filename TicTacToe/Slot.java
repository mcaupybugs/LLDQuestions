package TicTacToe;

enum SlotType {
    X,
    O,
    EMPTY
};

public class Slot {
    SlotType slotType;

    public Slot(SlotType slotType) {
        this.slotType = slotType;
    }
}
