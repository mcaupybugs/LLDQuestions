package TicTacToe;

import java.util.*;
import java.util.Scanner;

enum GameStatus {
    IN_PROGRESS,
    DRAW,
    WIN
}

public class Game {
    private PlayerManager playerManager;
    private Board board;
    private ArrayList<Player> players;
    private IWinningStrategy winningStrategy;
    private Queue<Player> playerQueue;
    private Scanner scanner = new Scanner(System.in);
    private GameStatus gameStatus;

    Game(int players, int boardSize) {
        this.playerManager = new PlayerManager();
        this.winningStrategy = new DefaultWinningStrategy();
        this.board = new Board(boardSize);
        this.players = playerManager.createPlayers(players);
    }

    void startGame() {
        gameStatus = GameStatus.IN_PROGRESS;
        playerQueue = new LinkedList<>(players);
        while (gameStatus == GameStatus.IN_PROGRESS) {
            Player currentPlayer = playerQueue.poll();

            int[] move = getPlayerMove(currentPlayer);
            board.placeMove(move[0], move[1], currentPlayer.getPlayerSlotType());

            if (winningStrategy.hasWinner(board, currentPlayer.getPlayerSlotType())) {
                gameStatus = GameStatus.WIN;
                System.out.println("Player " + currentPlayer.getPlayerSlotType() + " wins!");
                break;
            }

            if (board.isFull()) {
                gameStatus = GameStatus.DRAW;
                System.out.println("Game ended in a draw!");
                break;
            }

            board.printBoard();

            playerQueue.offer(currentPlayer);
        }
    }

    int[] getPlayerMove(Player player) {
        while (true) {
            System.out.print("Player " + player.getPlayerSlotType() + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.isValidMove(row, col)) {
                return new int[] { row, col };
            }

            System.out.println("Invalid move. Try again.");
        }
    }
}
