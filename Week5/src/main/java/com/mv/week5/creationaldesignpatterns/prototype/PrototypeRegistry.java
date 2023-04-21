package com.mv.week5.creationaldesignpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {

    private static Map<String, Shape> shapeRegistry = new HashMap<>();

    static {
        // Upcasting
        shapeRegistry.put("RECTANGLE", new Rectangle());
        shapeRegistry.put("CIRCLE", new Circle());
    }

    public static Shape getShape(String choice) throws CloneNotSupportedException {
        return shapeRegistry.getOrDefault(choice, null).clone();
    }


}
