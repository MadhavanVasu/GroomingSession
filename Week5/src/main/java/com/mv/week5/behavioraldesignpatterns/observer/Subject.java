package com.mv.week5.behavioraldesignpatterns.observer;

public interface Subject {

    public void register(Observer observer);

    public void unRegister(Observer observer);

    public void setMessage(String message);

    public void notifyObservers();


}
