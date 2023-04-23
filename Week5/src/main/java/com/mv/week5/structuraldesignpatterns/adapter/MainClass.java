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
    public static void main(String[] args) {

        Swiggy swiggy = new Swiggy();
        swiggy.addItem(new FoodItem("Naan", 100, "Sangeetha"));
        swiggy.addItem(new FoodItem("Noodles", 120, "A2B"));
        swiggy.addItem(new ItemAdapter(new GroceryItem("Bread Loaf", 35,"Rogers Supermarket")));
        System.out.println(swiggy.getItems());

    }
}
