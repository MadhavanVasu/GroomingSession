package com.mv.week5.behavioraldesignpatterns.flyweight;

public class Tree {

    // Intrinsic field
    // This constant data of an object is usually called the intrinsic state.
    // It lives within the object; other objects can only read it, not change it.
    // Here it is name and color of the tree
    private final String name;
    private final Color color;

    public Tree(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    // Extrinsic Field
    // The rest of the object’s state, often altered “from the outside” by other objects,
    // is called the extrinsic state.
    // Here it is the position of the Tree (x and y co-ordinates)
    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " of color " + color + " at position " + "(" + x + "," + y + ")");
    }

}
