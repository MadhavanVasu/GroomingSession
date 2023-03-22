package com.mv.week1.part1;

public class FinalKeyword {

    // Final Keyword -> Used to declare constants. Can change its value once assigned.
    public class A {
        // Can initialize final variable at the time of declaration
        final int a = 1;
        final int b;

        final int c;

        // Can initialize final variable in instance block
        {
            c = 2;
        }

        A() {
            // Can initialize final variable in constructor
            b = 1;
        }
    }

}
