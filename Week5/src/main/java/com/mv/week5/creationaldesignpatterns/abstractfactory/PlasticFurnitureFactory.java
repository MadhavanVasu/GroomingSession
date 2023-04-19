package com.mv.week5.creationaldesignpatterns.abstractfactory;

// Concrete factories produce a family of products that belong to a single variant.
// The factory guarantees that the resulting products are compatible.
// Signatures of the concrete factory's methods return an abstract product,
// while inside the method a concrete product is instantiated.
public class PlasticFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair getChair() {
        return new PlasticChair();
    }

    @Override
    public Table getTable() {
        return new PlasticTable();
    }
}
