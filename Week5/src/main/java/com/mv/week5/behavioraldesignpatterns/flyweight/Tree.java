package com.mv.week5.behavioraldesignpatterns.flyweight;

public class Tree {

    // Intrinsic field
    // This constant data of an object is usually called the intrinsic state.
    // It lives within the object; other objects can only read it, not change it.
    private TreeType type; // Contains tree name, tree color and other tree related data.

    // Extrinsic Field
    // The rest of the object’s state, often altered “from the outside” by other objects,
    // is called the extrinsic state.
    private int x;
    private int y;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        // System.out.println(type.hashCode());
        type.draw(x, y);
    }

}
