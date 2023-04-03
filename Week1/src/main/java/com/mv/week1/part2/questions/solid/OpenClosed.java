package com.mv.week1.part2.questions.solid;

import java.util.Scanner;

interface Operation {


    public int execute(int a, int b);

}

class Addition implements Operation {

//    String opName

    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class Subtraction implements Operation {

    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

class Multiplication implements Operation {

    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

interface Calculator {

    public int performOperation(int a, int b);

}

class SimpleCalculator implements Calculator {

    private final Operation operation;

    public SimpleCalculator(Operation operation) {
        this.operation = operation;
    }

    public int performOperation(int a, int b) {
        return operation.execute(a, b);
    }
}

public class OpenClosed {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter values for a and b :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print("Enter operation to be performed: ");
        String ch = sc.next();
        int result = 0;
        switch (ch) {
            case "+":
                Calculator addition = new SimpleCalculator(new Addition());
                result = addition.performOperation(a, b);
                System.out.println(result);
                break;
            case "-":
                Calculator subtraction = new SimpleCalculator(new Subtraction());
                result = subtraction.performOperation(a, b);
                System.out.println(result);
                break;
            case "*":
                Calculator multiplication = new SimpleCalculator(new Multiplication());
                result = multiplication.performOperation(a, b);
                System.out.println(result);
                break;

        }

    }
}
