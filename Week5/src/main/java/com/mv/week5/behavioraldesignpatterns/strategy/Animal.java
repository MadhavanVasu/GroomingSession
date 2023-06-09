package com.mv.week5.behavioraldesignpatterns.strategy;

// The Strategy pattern suggests that you take a class that does something specific
// in a lot of different ways and extract all of these algorithms into separate classes called strategies.
//The original class, called context, must have a field for storing a reference to one of the strategies.
// The context delegates the work to a linked strategy object instead of executing it on its own.
//The context isn’t responsible for selecting an appropriate algorithm for the job.
// Instead, the client passes the desired strategy to the context.
// In fact, the context doesn’t know much about strategies.
// It works with all strategies through the same generic interface,
// which only exposes a single method for triggering the algorithm encapsulated within the selected strategy.

// Here Animal is the context class
public class Animal {

    private String name;
    private String favFood;
    private int weight;
    private int height;
    protected Flys flyingType;

    private String sound;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Flys getFlyingType() {
        return flyingType;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setFlyingType(Flys flyingType) {
        this.flyingType = flyingType;
    }

    public void tryToFly() {
        flyingType.fly();
    }
}
