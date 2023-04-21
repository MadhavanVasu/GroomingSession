package com.mv.week5.creationaldesignpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {

    private static Map<String, Shape> shapeRegistry = new HashMap<>();

    static {
        shapeRegistry.put("RECTANGLE", new Rectangle());
        shapeRegistry.put("CIRCLE", new Circle());
    }

    public static Shape getShape(String choice) {
        return shapeRegistry.getOrDefault(choice, null);
    }


}
