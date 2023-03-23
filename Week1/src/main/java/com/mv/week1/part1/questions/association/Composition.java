package com.mv.week1.part1.questions.association;

class Truck {

    String model;
    Engine engine;

    public Truck() {
        this.engine = new Engine();
    }
}

class Engine {

    String type;

}


public class Composition {

    // Composition is another version of "has-a" relationship
    // Here truck is the container object
    // Engine is the contained object
    // The contained object cannot exist without container object
    // So if truck is not present, it's engine won't be present
    Truck truck = new Truck();


}
