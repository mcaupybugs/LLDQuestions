package SnakeLadder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");
        List<BoardEntity> boardEntities = List.of(
            new Snake(17, 7),
            new Snake(54, 34),
            new Snake(62, 19),
            new Snake(98, 79),
            new Ladder(3, 38),
            new Ladder(24, 33),
            new Ladder(42, 93),
            new Ladder(72, 84)
        );

        Map<Integer, BoardEntity> boardEntityMap = new HashMap<>();
        for (BoardEntity boardEntity : boardEntities) {
            boardEntityMap.put(boardEntity.getStart(), boardEntity);
        }

        List<String> players = Arrays.asList("Alice", "Bob", "Charlie");

        Game game = new Game.Builder()
            .setBoard(100, boardEntityMap)
            .setPlayers(players)
            .setDice(new Dice(1, 6))
            .build();
        game.startGame();
    }
}