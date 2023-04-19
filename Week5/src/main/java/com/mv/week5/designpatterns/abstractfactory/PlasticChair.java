package com.mv.week5.designpatterns.abstractfactory;

public class PlasticChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Sat on Plastic Chair");
    }
}
