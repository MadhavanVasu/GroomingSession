package com.mv.week5.designpatterns.factory.abstractfactory;

public class WoodenTable implements Table {
    @Override
    public void placeItems() {
        System.out.println("Placed items on Wooden Table");
    }
}
