package com.mv.week5.creationaldesignpatterns.abstractfactory;

public class PlasticChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Sat on Plastic Chair");
    }
}
