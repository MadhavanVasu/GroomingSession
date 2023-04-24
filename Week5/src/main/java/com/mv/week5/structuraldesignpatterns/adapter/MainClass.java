package com.mv.week5.structuraldesignpatterns.adapter;

public class MainClass {

    // Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
    // Adapter design pattern is used so that two unrelated interfaces can work together.
    // The object that joins these unrelated interface is called an Adapter.
    // Adapter Design Pattern Example in JDK
    //Some of the adapter design pattern example I could easily find in JDK classes are;
    // java.util.Arrays#asList()
    // java.io.InputStreamReader(InputStream) (returns a Reader)
    // java.io.OutputStreamWriter(OutputStream) (returns a Writer)

    // Adapter is a special object that converts the interface of one object so that another object
    // can understand it.
    // An adapter wraps one of the objects to hide the complexity of conversion happening behind the scenes.
    // The wrapped object isn’t even aware of the adapter.

    // The adapter gets an interface, compatible with one of the existing objects.
    // Using this interface, the existing object can safely call the adapter’s methods.
    // Upon receiving a call, the adapter passes the request to the second object,
    // but in a format and order that the second object expects.
    public static void main(String[] args) {

        Swiggy swiggy = new Swiggy();
        swiggy.addItem(new FoodItem("Naan", 100, "Sangeetha"));
        swiggy.addItem(new FoodItem("Noodles", 120, "A2B"));
        swiggy.addItem(new ItemAdapter(new GroceryItem("Bread Loaf", 35, "Rogers Supermarket")));
        System.out.println(swiggy.getItems());

    }
}
