package com.mv.week5.behavioraldesignpatterns.state;

public class MainClass {

    // State is a behavioral design pattern that allows an object to change the behavior
    // when its internal state changes.
    // The pattern extracts state-related behaviors into separate state classes
    // and forces the original object to delegate the work to an instance of these classes,
    // instead of acting on its own.
    public static void main(String[] args) {
        Package pkg = new Package();
        pkg.previousState();
        pkg.currentStatus();
        pkg.nextState();
        pkg.currentStatus();
        pkg.previousState();
        pkg.currentStatus();
    }

}
