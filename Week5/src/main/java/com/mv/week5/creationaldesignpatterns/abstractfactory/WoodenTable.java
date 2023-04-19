package com.mv.week5.creationaldesignpatterns.abstractfactory;

public class WoodenTable implements Table {
    @Override
    public void placeItems() {
        System.out.println("Placed items on Wooden Table");
    }
}
