package com.mv.week5.behavioraldesignpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Forest {
    private Map<Integer, Tree> trees = new HashMap<>();
    private int treeId = 0;

    public void plantTree(int x, int y, String name, Color color) {
        TreeType type = TreeTypeFactory.getTreeType(name, color);
        Tree tree = new Tree(x, y, type);
        trees.put(treeId++, tree);
    }

    public void draw() {
        for (Tree tree : trees.values()) {
            tree.draw();
        }
    }
}