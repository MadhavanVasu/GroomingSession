package com.mv.week5.behavioraldesignpatterns.observer;

public class MainClass {

    // Observer Pattern is one of the behavioral design pattern.
    // Observer design pattern is useful when you are interested in the state of an object
    // and want to get notified whenever there is any change.
    // In observer pattern, the object that watch on the state of another object are called Observer
    // and the object that is being watched is called Subject.

    public static void main(String[] args) {

        Subject moviesTopic = new MoviesTopic();
        Subject techTopic = new TechTopic();

        Observer observer1 = new Subscriber();
        Observer observer2 = new Subscriber();
        Observer observer3 = new Subscriber();
        Observer observer4 = new Subscriber();

        moviesTopic.register(observer1);
        moviesTopic.register(observer3);
        techTopic.register(observer3);
        techTopic.register(observer4);
        techTopic.register(observer2);

        techTopic.setMessage("Apple is working on an AI-powered health coaching service");
        moviesTopic.setMessage("PS-2 releasing on April 28 2023!");

        techTopic.unRegister(observer2);

        techTopic.setMessage("WhatsApp rolls out multi-device login feature");


    }

}
