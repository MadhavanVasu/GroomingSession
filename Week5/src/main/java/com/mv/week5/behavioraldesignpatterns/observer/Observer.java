package com.mv.week5.behavioraldesignpatterns.observer;

public interface Observer {

    public void update(String topic, String message);

    public int getObserverId();


}
