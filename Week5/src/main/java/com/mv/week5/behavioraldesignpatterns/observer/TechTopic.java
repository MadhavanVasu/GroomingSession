package com.mv.week5.behavioraldesignpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class TechTopic implements Subject {

    private final String topicName;
    private List<Observer> observers;

    // Here message is the state.
    // Whenever it changes, observers are notified.
    // Observers can register themselves to receive notification when the state changes.
    private String message;
    private boolean isChanged;

    // The reason why we use a private Object for lock here is that if we use this as monitor
    // any other thread using our subject as lock for some synchronized block
    // might unnecessarily block our thread.
    // Like for example if main uses subject as monitor and another thread we spawn from main trying
    // to register observer will have unnecessarily wait till main leave synchronized block.
    private final Object lock;

    public TechTopic() {
        this.observers = new ArrayList<>();
        this.message = "";
        this.isChanged = false;
        this.lock = new Object();
        this.topicName = "Tech News";
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) throw new NullPointerException("Not a valid observer");
        synchronized (lock) {
            observers.add(observer);
            System.out.println("Subscriber with ID " + observer.getObserverId() + " added to subscribers in " + topicName);
        }

    }

    @Override
    public void unRegister(Observer observer) {
        if (observers.contains(observer)) {
            synchronized (lock) {
                observers.remove(observer);
            }
            System.out.println("Subscriber with ID " + observer.getObserverId() + " removed : " + topicName);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersClone;
        synchronized (lock) {
            if (!isChanged) return;
            observersClone = new ArrayList<>(observers);
            isChanged = false;
        }
        for (Observer observer : observersClone)
            observer.update(topicName, message);
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
        this.isChanged = true;
        notifyObservers();
    }

}
