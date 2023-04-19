package com.mv.week5.designpatterns.factory;

import java.util.Scanner;

enum Shapes {

    RECTANGLE,
    SQUARE

}

interface Shape {
    public int area();
}

class Square implements Shape {


    @Override
    public int area() {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of the side of square : ");
        a = sc.nextInt();
        return a * a;
    }
}

class Rectangle implements Shape {

    @Override
    public int area() {
        int l, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of the rectangle : ");
        l = sc.nextInt();
        System.out.println("Enter breadth of the rectangle : ");
        b = sc.nextInt();
        return l * b;
    }
}

// We can keep Factory class Singleton, or we can keep the method that returns the subclass as static.
// Notice that based on the input parameter, different subclass is created and returned.
// getShape() is the factory method.


class ShapeFactory {

    private ShapeFactory() {

    }

    public static Shape getShape(Shapes shape) {
        switch (shape) {
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            default:
                return null;
        }
    }

}

public class FactoryDesignPattern {

    // The factory design pattern is used when we have a superclass with multiple subclasses
    // and based on input, we need to return one of the subclass.
    // This pattern takes out the responsibility of the instantiation of a class from the client program
    // to the factory class.
    // Factory Method pattern is a simplified version of Abstract Factory pattern.
    // Factory Method pattern is responsible for creating products that belong to one family,
    // while Abstract Factory pattern deals with multiple families of products.
    public static void main(String[] args) {
        Shape square = ShapeFactory.getShape(Shapes.SQUARE);
        System.out.println(square.area());
        System.out.println(square.getClass());

        Shape rectangle = ShapeFactory.getShape(Shapes.RECTANGLE);
        System.out.println(rectangle.area());
        System.out.println(rectangle.getClass());
    }

}
