package SnakeLadder;

public class Player{
    private final String name;
    private int position;

    public Player(String name){
        this.name = name;
        this.position = 0;
    }

    public void move(int finalPosition){
        this.position = finalPosition;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }
}
