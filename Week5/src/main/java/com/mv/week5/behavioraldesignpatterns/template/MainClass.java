package com.mv.week5.behavioraldesignpatterns.template;

public class MainClass {
    // Template method design pattern is to define an algorithm as a skeleton of operations
    // and leave the details to be implemented by the child classes.
    // The overall structure and sequence of the algorithm are preserved by the parent class.
    public static void main(String[] args)
    {
        OrderProcessTemplate onlineOrder = new OnlineOrder();
        onlineOrder.processOrder(true);
        System.out.println();
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }
}
