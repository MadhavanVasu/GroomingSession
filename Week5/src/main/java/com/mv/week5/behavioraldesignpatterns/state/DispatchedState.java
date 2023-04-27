package com.mv.week5.behavioraldesignpatterns.state;

public class DispatchedState implements State {
    @Override
    public void next(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void printState() {
        System.out.println("Package is in dispatched state");
    }
}
