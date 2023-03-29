package com.mv.week1.java_constructs_oops;

public class RandomDoubts {

    static int a = 5;

    public static void main(String[] args) {
        // Stack Overflow error -> Call main inside main
        // main(new String[] {"a","b","c"});

        // Main is recursively called until static variable becomes 0
        if (a > 0) {
            System.out.println(a);
            --a;
            main(new String[]{"a", "b", "c"});
        }
    }

}
