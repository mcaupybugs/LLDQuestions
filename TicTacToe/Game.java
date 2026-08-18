package TicTacToe;

import java.util.*;
import java.util.Scanner;

public class Game {
    PlayerManager playerManager;
    Board board;
    ArrayList<Player> players;
    Queue<Player> playerQueue;
    Scanner scanner = new Scanner(System.in);

    Game(int players, int boardSize) {
        this.playerManager = new PlayerManager();
        this.board = new Board(boardSize);
        this.players = playerManager.createPlayers(players);
    }

    void startGame() {
        playerQueue = new LinkedList<>(players);
        while (true) {
            Player currentPlayer = playerQueue.poll();

            int[] move = getPlayerMove(currentPlayer);
            board.placeMove(move[0], move[1], currentPlayer.playerSlotType);

            if (board.hasWinner(currentPlayer.playerSlotType)) {
                System.out.println("Player " + currentPlayer.playerSlotType + " wins!");
                break;
            }

            if (board.isFull()) {
                System.out.println("Game ended in a draw!");
                break;
            }

            board.printBoard();

            playerQueue.offer(currentPlayer);
        }
    }

    int[] getPlayerMove(Player player) {
        while (true) {
            System.out.print("Player " + player.playerSlotType + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.isValidMove(row, col)) {
                return new int[] { row, col };
            }

            System.out.println("Invalid move. Try again.");
        }
    }

}
