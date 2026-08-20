package SnakeLadder;

import java.util.HashMap;
import java.util.Map;

public class Board{
    private final Map<Integer, Integer> snakeAndLadder;
    private final int size;
    
    public Board(int size, Map<Integer,BoardEntity> entities){
        this.snakeAndLadder = new HashMap<>();
        for(Map.Entry<Integer, BoardEntity> entry : entities.entrySet()){
            this.snakeAndLadder.put(entry.getKey(), entry.getValue().getEnd());
        }
        this.size = size;
    }
	
    boolean checkWinCondition(int currentPosition){
        return currentPosition == this.size;
    }

    public int getFinalPosition(int currentPosition, int diceRoll){
        int newPosition = currentPosition + diceRoll;
        if(newPosition > this.size){
            return currentPosition;
        }
        if(this.snakeAndLadder.containsKey(newPosition)){
            return this.snakeAndLadder.get(newPosition);
        }
        return newPosition;
    }
}
