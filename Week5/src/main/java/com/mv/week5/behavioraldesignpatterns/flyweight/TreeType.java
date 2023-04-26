package com.mv.week5.behavioraldesignpatterns.flyweight;

public class TreeType {
    private String name;
    private Color color;

    public TreeType(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " of color " + color + " at position " + "(" + x + "," + y + ")");
    }

}
