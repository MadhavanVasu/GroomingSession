package com.mv.week5.structuraldesignpatterns.decorator;

public class BasePizza implements Pizza {


    @Override
    public void bake() {
        System.out.println("Baking Base Pizza...");
    }
}
