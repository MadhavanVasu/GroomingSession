package com.mv.week5.behavioraldesignpatterns.observer;

public class Subscriber implements Observer {

    private static int idCounter;
    private int subscriberID;

    public Subscriber() {
        this.subscriberID = ++idCounter;
    }

    @Override
    public void update(String topic, String message) {
        System.out.println("Subscriber " + subscriberID + " got the message \"" + message + "\" from topic \"" + topic + "\"");
    }

    @Override
    public int getObserverId() {
        return subscriberID;
    }


}
