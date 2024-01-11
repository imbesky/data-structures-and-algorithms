package org.example.section2;

import java.util.Stack;

public class TowerOfHanoi {
    /*
    task: Write a program that prints the shortest sequence of moves
    rule:
    1. can only move one ring each time
    2. Smaller radius rings can never be below larger radius rings
    3. can only take the ring at the top of the peg and drop it to the top of another peg
     */
    public static void main(String[] args) {
        int height = 10;
        Stack<Integer> pegA = new Stack<>();
        for (int i = height; i > 0; i--){
            pegA.push(i);
        }
        Stack<Integer> pegB = new Stack<>();
        Stack<Integer> pegC = new Stack<>();
        System.out.println(move(height, pegA, "peg A", pegB, "peg B", pegC, "peg C"));
    }
    private static int move(
            int height,
            Stack<Integer> departure,String departureName,
            Stack<Integer> arrival, String arrivalName,
            Stack<Integer> spare, String spareName){
        if (height == 1){
            int move = departure.pop();
            System.out.println("moved " + move + " from " + departureName + " to " + arrivalName);
            arrival.push(move);
            return 1;
        }
        int result = 1;
        result += move(height - 1, departure, departureName, spare, spareName, arrival, arrivalName);
        int move = departure.pop();
        System.out.println("moved " + move + " from " + departureName + " to " + arrivalName);
        arrival.push(move);
        result += move(height - 1, spare, spareName, arrival, arrivalName, departure, departureName);
        return result;
    }
}
