package TicTacToe;

import java.util.ArrayList;

public class PlayerManager {
    PlayerManager() {

    }

    ArrayList<Player> createPlayers(int numberOfPlayers) {
        if(numberOfPlayers != 2) {
            throw new IllegalArgumentException("Only 2 players are allowed in Tic Tac Toe.");
        }
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(SlotType.values()[i]);
            players.add(player);
        }
        return players;
    }
}
