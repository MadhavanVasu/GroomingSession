package com.mv.week5.behavioraldesignpatterns.strategy;

// Flys is the strategy here
// It can have multiple strategy algorithms implemented by concrete class
// It just exposes a single method which the context class can use
// Client can choose any specific algorithm (CanFly, CannotFly, etc).
public interface Flys {

    public void fly();

}
