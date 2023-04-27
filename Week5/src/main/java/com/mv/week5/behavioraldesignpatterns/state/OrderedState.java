package com.mv.week5.behavioraldesignpatterns.state;

public class OrderedState implements State {
    @Override
    public void next(Package pkg) {
        pkg.setState(new DispatchedState());
    }

    @Override
    public void prev(Package pkg) {
        System.out.println("The package is in its root state");
    }

    @Override
    public void printState() {
        System.out.println("Package is in ordered state");
    }
}
