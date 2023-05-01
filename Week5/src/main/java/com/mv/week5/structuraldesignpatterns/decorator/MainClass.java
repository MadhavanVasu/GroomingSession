package com.mv.week5.structuraldesignpatterns.decorator;

public class MainClass {

    // Decorator is a structural pattern that allows adding new behaviors to objects dynamically by
    // placing them inside special wrapper objects, called decorators.

    // Example : We can have a class ReaderWriter or DataSource (read() & write(String)
    // A concrete class called FileDataSource which can read data and write data to a file
    // We can have a DataSourcedDecorator which implements DataSource
    public static void main(String[] args) {
        Pizza pizza = new VeggiePizzaDecorator(new BasePizza());
        pizza.bake();
    }

}
