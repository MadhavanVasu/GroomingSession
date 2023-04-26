package com.mv.week5.behavioraldesignpatterns.strategy;

public class Bird extends Animal {

    private String classification;

    public Bird() {
        this.flyingType = new CanFly();
        setSound("Tweet");
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
