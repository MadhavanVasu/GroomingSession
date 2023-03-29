package com.mv.week2;

// https://www.scaler.com/topics/java/variable-hiding-and-variable-shadowing-in-java/

public class VariableShadowing {

    // static or class variable
    // Loaded in memory only once
    // Only a single copy of the class variable per class
    public static int x = 10;

    // instance variable -> variable belonging to an object -> Seperate memory for each object
    public int y = 20;

    // Method Argument Shadowing
    public int argumentShadowing(int y, int x) {
        return y + x;
    }

    public int localVariableShadowing() {
        // Local variable shadowing
        int y = 10;
        return y;
    }

    public static void main(String[] args) {
        // local variable -> Inside a method, block or constructor
        int z = 30;

        // Local variable shadowing
        int x = 10;
    }

}
