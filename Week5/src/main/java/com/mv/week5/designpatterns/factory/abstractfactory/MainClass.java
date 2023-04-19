package com.mv.week5.designpatterns.factory.abstractfactory;

import java.util.Scanner;

enum FurnitureType {

    PLASTIC,
    WOODEN

}

// Abstract Factory is a creational design pattern that lets you produce families of related objects
// without specifying their concrete classes.

// https://refactoring.guru/design-patterns/abstract-factory

public class MainClass {

    public static FurnitureFactory factory;
    public static Chair chair;
    public static Table table;

    public static void main(String[] args) {

        String choice;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice of furniture (PLASTIC or WOODEN) : ");
        choice = sc.next();
        if (choice.equals(FurnitureType.PLASTIC.toString()))
            factory = new PlasticFurnitureFactory();
        else if (choice.equals(FurnitureType.WOODEN.toString()))
            factory = new WoodenFurnitureFactory();

        try {
            chair = factory.getChair();
            table = factory.getTable();

            chair.sit();
            table.placeItems();
        } catch (Exception e) {
            System.out.println("Invalid choice");
        }


    }

}
