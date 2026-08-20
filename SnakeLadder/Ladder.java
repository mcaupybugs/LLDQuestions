package SnakeLadder;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
        if(start >= end){
            throw new IllegalArgumentException(
                    "Ladder head must be less than its end."
                    );
        }
    }
}
