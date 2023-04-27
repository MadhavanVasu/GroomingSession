package com.mv.week5.behavioraldesignpatterns.state;

public class DeliveredState implements State {
    @Override
    public void next(Package pkg) {
        System.out.println("The package is in its final state");
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new DispatchedState());
    }

    @Override
    public void printState() {
        System.out.println("Package is in delivered state");
    }
}
