package com.mv.week5.designpatterns.abstractfactory;

public class WoodenChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Sat on Wooden Chair");
    }
}
