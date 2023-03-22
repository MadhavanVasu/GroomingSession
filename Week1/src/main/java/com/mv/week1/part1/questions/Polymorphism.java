package com.mv.week1.part1.questions;

class SimpleCalculator {

    public SimpleCalculator() {
        System.out.println("In SimpleCalculator constructor");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Simple for loop
        for (int i = 0; i < n; i++)
            sum += nums[i];
        return sum;
    }
}

class Calculator extends SimpleCalculator {
    public Calculator() {
        // Super must be first statement in derived class constructor body
        super();
        System.out.println("In Calculator constructor");
    }

    @Override
    public int add(int[] nums) {
        int sum = 0;

        // for each loop
        for (int x : nums)
            sum += x;
        return sum;
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();

        // Compile Time polymorphism -> Method Overloading
        System.out.println(calc.add(1, 2));
        System.out.println(calc.add(1, 2, 3));

        //Runtime Polymorphism -> Method Overriding
        SimpleCalculator calc2 = new Calculator();
        System.out.println(calc2.add(new int[]{1, 2, 3, 4}));



    }


}
