package com.mv.week5.behavioraldesignpatterns.flyweight;

public class MainClass {

    // Flyweight is a structural design pattern that lets you fit more objects into the available
    // amount of RAM by sharing common parts of state between multiple objects instead of
    // keeping all of the data in each object.

    public static void main(String[] args) {

        DrawingApp drawingApp = new DrawingApp();
        drawingApp.drawTree(1, 2, "Redwood Tree", Color.RED);
        drawingApp.drawTree(2, 3, "Banyan Tree", Color.BROWN);
        drawingApp.drawTree(3, 4, "Bamboo Tree", Color.GREEN);
        drawingApp.drawTree(4, 5, "Redwood Tree", Color.RED);


    }

}
