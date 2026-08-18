package TicTacToe;

public class TicTacToeApp {
    public static void main(String[] args) {
        int boardSize = 3;
        int numberOfPlayers = 2;
        Game game = new Game(numberOfPlayers, boardSize);
        game.startGame();
    }
}
