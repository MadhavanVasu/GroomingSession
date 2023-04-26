package com.mv.week5.behavioraldesignpatterns.strategy;

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
