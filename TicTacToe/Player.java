package TicTacToe;

public class Player implements IPlayer {

    SlotType playerSlotType;

    public Player(SlotType playerSlotType) {
        this.playerSlotType = playerSlotType;
    }

    @Override
    public void move(Slot slot) {
        // Implementation for player move
        slot.slotType = this.playerSlotType;
    }

}
