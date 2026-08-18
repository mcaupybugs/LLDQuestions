package TicTacToe;

public class Player  {

    private SlotType playerSlotType;

    public Player(SlotType playerSlotType) {
        this.playerSlotType = playerSlotType;
    }

    public SlotType getPlayerSlotType() {
        return playerSlotType;
    }
}
