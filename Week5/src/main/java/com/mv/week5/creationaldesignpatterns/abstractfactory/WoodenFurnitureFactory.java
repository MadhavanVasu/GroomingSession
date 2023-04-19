package com.mv.week5.creationaldesignpatterns.abstractfactory;

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
