package com.mv.week5.structuraldesignpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    static Map<String, Tree> map = new HashMap<>();

    public TreeFactory() {
        this.map = new HashMap<>();
    }

    public static Tree getTree(String name, Color color) {
        String type = name + " " + color;
        Tree tree = null;
        if (map.containsKey(type)) {
            tree = map.get(type);
        } else {
            tree = new Tree(name, color);
            map.put(type, tree);
        }
        return tree;
    }


}
