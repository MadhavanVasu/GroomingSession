package com.mv.week5.designpatterns.abstractfactory;

public class PlasticTable implements Table {
    @Override
    public void placeItems() {
        System.out.println("Placed items on Plastic Table");
    }
}
