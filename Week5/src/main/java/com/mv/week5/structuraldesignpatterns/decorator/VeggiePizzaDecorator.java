package com.mv.week5.structuraldesignpatterns.decorator;

public class VeggiePizzaDecorator extends PizzaDecorator {


    public VeggiePizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    public void bake() {
        super.bake();
        System.out.println("Baking Veggie Pizza...");
    }

}
