package com.mv.week5.behavioraldesignpatterns.flyweight;

public class MainClass {

    // Flyweight is a structural design pattern that lets you fit more objects into the available
    // amount of RAM by sharing common parts of state between multiple objects instead of
    // keeping all of the data in each object.

    public static void main(String[] args) {

        Forest forest = new Forest();
        forest.plantTree(1, 2, "Redwood Tree", Color.RED);
        forest.plantTree(2, 3, "Banyan Tree", Color.BROWN);
        forest.plantTree(3, 4, "Bamboo Tree", Color.GREEN);
        forest.plantTree(4, 5, "Redwood Tree", Color.RED);

        forest.draw();

    }

}
