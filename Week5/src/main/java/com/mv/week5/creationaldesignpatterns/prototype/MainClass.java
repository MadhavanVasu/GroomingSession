package com.mv.week5.creationaldesignpatterns.prototype;

public class MainClass {
    // Prototype : This is the prototype of actual object as discussed above.
    // Prototype registry : This is used as registry service to have all prototypes accessible
    // using simple string parameters.
    // Client : Client will be responsible for using registry service to access prototype instances.

    public static void main(String[] args) throws CloneNotSupportedException {

        // Downcasting
        // Casting from object of type parent to sub-class type
        Circle circle = (Circle) PrototypeRegistry.getShape("CIRCLE");
        circle.draw();
        System.out.println(circle.hashCode());

        Shape rectangle = PrototypeRegistry.getShape("RECTANGLE");
        rectangle.draw();

    }

}
