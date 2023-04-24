package com.mv.week5.structuraldesignpatterns.decorator;

public class VeggiePizzaDecorator extends PizzaDecorator {

    private Pizza pizza;

    public VeggiePizzaDecorator(Pizza pizza) {
        super(pizza);
        this.pizza = pizza;
    }

    public void bake() {
        super.bake();
        System.out.println("Baking Veggie Pizza...");
    }

}
