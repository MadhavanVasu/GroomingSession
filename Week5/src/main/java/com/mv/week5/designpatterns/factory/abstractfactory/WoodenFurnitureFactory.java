package com.mv.week5.designpatterns.factory.abstractfactory;

public class WoodenFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair getChair() {
        return new WoodenChair();
    }

    @Override
    public Table getTable() {
        return new WoodenTable();
    }
}
