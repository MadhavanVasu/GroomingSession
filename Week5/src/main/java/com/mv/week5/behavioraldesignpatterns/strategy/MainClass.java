package com.mv.week5.behavioraldesignpatterns.strategy;

public class MainClass {

    // Strategy design pattern is one of the behavioral design pattern.
    // Strategy pattern is used when we have multiple algorithm for a specific task
    // and client decides the actual implementation to be used at runtime.

    // Strategy pattern is also known as Policy Pattern.
    // We define multiple algorithms and let client application pass the algorithm to be used as a parameter.
    // One of the best example of strategy pattern is Collections.sort() method that takes Comparator parameter.
    // Based on the different implementations of Comparator interfaces,
    // the Objects are getting sorted in different ways.

    // For our example, we will try to implement a simple Shopping Cart where we have two payment strategies
    // - using Credit Card or using PayPal.
    // First of all we will create the interface for our strategy pattern example,
    // in our case to pay the amount passed as argument.

    // We can have this Task either as a field or can also pass them in runtime.

    public static void main(String[] args) {
        Animal rocky = new Dog();
        Animal flappy = new Bird();
        // Initially dog cannot fly when we try to do tryToFlyTask()
        rocky.tryToFly();
        flappy.tryToFly();

        // We can change this dynamically in runtime.
        // Same like Collections.sort()
        // Initially it can sort only in natural order
        // We can pass the algorithm in runtime by passing object of type Comparator
        rocky.setFlyingType(new CanFly());
        rocky.tryToFly();


    }


}
