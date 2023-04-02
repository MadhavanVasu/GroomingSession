package com.mv.week1.part2.questions.solid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Operation {


    public int execution(int a, int b);

}

class Addition implements Operation {

//    String opName

    @Override
    public int execution(int a, int b) {
        return a + b;
    }
}

class Subtraction implements Operation {

    @Override
    public int execution(int a, int b) {
        return a - b;
    }
}

interface Calculator {

    public void addOperation(Operation op);

    public void performOperation();

}

class SimpleCalculator implements Calculator {

    List<Operation> operations;

    public SimpleCalculator() {
        this.operations = new ArrayList<>();
    }

    @Override
    public void addOperation(Operation op) {
        this.operations.add(op);
    }

    @Override
    public void performOperation() {

        while (true) {
            System.out.println("1. Addition\n2.Subtraction\n");
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            int a, b;
            System.out.println("Enter the two numbers :\n");
            a = sc.nextInt();
            b = sc.nextInt();
//            switch (choice) {
//                case 1:
//                    for (Operation x : operations) {
//                        x.getClass()==
//                    }
//            }
        }

    }
}

public class OpenClose {

    public static void main(String[] args) {
        Calculator simpleCalc = new SimpleCalculator();
        Operation addition = new Addition();
        Operation subtraction = new Subtraction();
        simpleCalc.addOperation(addition);
        simpleCalc.addOperation(subtraction);
        simpleCalc.performOperation();
    }


}
