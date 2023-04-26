package com.mv.week5.behavioraldesignpatterns.strategy;

public class CannotFly implements Flys {
    @Override
    public void fly() {
        System.out.println("I cannot fly...");
    }
}
