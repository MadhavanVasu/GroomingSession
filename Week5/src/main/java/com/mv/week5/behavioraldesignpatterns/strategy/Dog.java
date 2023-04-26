package com.mv.week5.behavioraldesignpatterns.strategy;

public class Dog extends Animal {

    private String breed;

    public Dog() {
        this.flyingType = new CannotFly();
        setSound("Bark");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
