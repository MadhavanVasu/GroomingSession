package com.mv.week1.part1;

public class Boxing {
    public static int j = 0;

    public static void main(String[] args) {
        int x = 10;
        Integer y = x; // auto-boxing

        int z = y; // unboxing
        int k = 10;
        {
            // Local to this block
            int j = 10;
            System.out.println(j);
//            int k  =0;
        }
        System.out.println(j);
    }

}
