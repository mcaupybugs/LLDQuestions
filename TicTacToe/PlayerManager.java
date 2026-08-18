package TicTacToe;

import java.util.ArrayList;

public class PlayerManager {
    PlayerManager() {

    }

    ArrayList<Player> createPlayers(int numberOfPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(SlotType.values()[i]);
            players.add(player);
        }
        return players;
    }
}
