package SnakeLadder;

import java.util.concurrent.ThreadLocalRandom;
public class Dice{
    private final int minValue;
    private final int maxValue;

    public Dice(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int rollDice(){
        int totalRoll = 0;
        int randomRoll = ThreadLocalRandom.current().nextInt(this.minValue, this.maxValue + 1);
        int count = 0;
        while(randomRoll == 6){
            count++;
            if(count==3){
                return 0;
            }    
            totalRoll+= randomRoll;
        randomRoll = ThreadLocalRandom.current().nextInt(this.minValue, this.maxValue + 1);
        }
        return totalRoll + randomRoll;
    }
}
