package SnakeLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

enum GameStatus{
    IN_PROGRESS,
    FINISHED,
    NOT_STARTED;
}

public class Game{
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private GameStatus gameStatus;
    private static Builder builder;

    public Game(Builder builder){
        this.board = builder.board;
        this.players = builder.players;
        this.dice = builder.dice;
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void startGame(){
        this.gameStatus = GameStatus.IN_PROGRESS;
        while(this.gameStatus==GameStatus.IN_PROGRESS){
            Player player = players.poll();
            this.takeTurn(player);
            if(this.board.checkWinCondition(player.getPosition())){
                this.gameStatus = GameStatus.FINISHED;
            } else {
                this.players.offer(player);
            }
        }
    } 

    public void takeTurn(Player player){
        int diceRoll = this.dice.rollDice();
        System.out.println(player.getName() + " rolled a " + diceRoll);
        if(diceRoll == 0){
            return;
        }
        int finalPosition = board.getFinalPosition(player.getPosition(), diceRoll);
        System.out.println(player.getName() + " moved from " + player.getPosition() + " to " + finalPosition);
        player.move(finalPosition);
    }


    public static class Builder {
        private Board board;
        private Queue<Player> players;
        private Dice dice;

        public Builder setBoard(int boardSize, Map<Integer, BoardEntity> entities){
            this.board = new Board(boardSize, entities);
            return this;
        }

        public Builder setPlayers(List<String> playerNames){
            this.players = new LinkedList<>();
            for(String playerName: playerNames){
                players.add(new Player(playerName));
            }
            return this;
        }

        public Builder setDice(Dice dice){
            this.dice = dice;
            return this;
        }

        public Game build(){
            if(board == null || players == null || dice == null){
                throw new IllegalStateException("Things null");
            }
            return new Game(this);
        }
    }
}
