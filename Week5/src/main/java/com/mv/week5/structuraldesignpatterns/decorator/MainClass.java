package com.mv.week5.structuraldesignpatterns.decorator;

public class MainClass {

    public static void main(String[] args) {
        Pizza pizza = new VeggiePizzaDecorator(new BasePizza());
        pizza.bake();
    }

}
