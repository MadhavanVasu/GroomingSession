package com.mv.week5.behavioraldesignpatterns.flyweight;


public class DrawingApp {

    public void drawTree(int x, int y, String name, Color color) {
        // We check if the tree is already present in HashMap.
        // If present it returns the same Tree object.
        // If not it'll create new object of Tree and returns it everytime the same parameters are passed.
        // So if we try to print the hashCode() it would be same for Tree with same attributes.
        // So it draws the same Tree at a different co-ordinates (extrinsic attributes) which are passed to the method.
        Tree tree = TreeFactory.getTree(name, color);
//        System.out.println(tree.hashCode());
        tree.draw(x, y);
    }

}