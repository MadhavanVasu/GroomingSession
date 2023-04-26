package com.mv.week5.behavioraldesignpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {

    static Map<String, TreeType> map = new HashMap<>();

    public TreeTypeFactory() {
        this.map = new HashMap<>();
    }

    public static TreeType getTreeType(String name, Color color) {
        String type = name + " " + color;
        TreeType treeType = null;
        if (map.containsKey(type)) {
            treeType = map.get(type);
        } else {
            treeType = new TreeType(name, color);
            map.put(type, treeType);
        }
        return treeType;
    }


}
