package com.mv.week5.behavioraldesignpatterns.state;

public class Package {

    private State state;

    public Package() {
        this.state = new OrderedState();
    }

    public void currentStatus() {
        state.printState();
    }

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void setState(State state) {
        this.state = state;
    }

}
