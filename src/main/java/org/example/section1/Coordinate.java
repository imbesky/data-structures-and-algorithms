package org.example.section1;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println("Default constructor called");
    }


    public Coordinate(int x){
        this(x, 0);
        System.out.println("Constructor chaining occurred");
    }

    public void values(){
        System.out.println("x: " + x + ", y: " + y);
    }
}
