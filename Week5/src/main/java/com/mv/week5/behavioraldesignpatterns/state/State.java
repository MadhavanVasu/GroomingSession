package com.mv.week5.behavioraldesignpatterns.state;

public interface State {

    public void next(Package pkg);

    public void prev(Package pkg);

    public void printState();

}
