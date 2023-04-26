package com.mv.week5.behavioraldesignpatterns.strategy;

public class CanFly implements Flys {
    @Override
    public void fly() {
        System.out.println("I can fly...");
    }
}
