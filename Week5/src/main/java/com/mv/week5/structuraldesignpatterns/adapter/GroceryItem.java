package com.mv.week5.structuraldesignpatterns.adapter;

public class GroceryItem {

    private String name;
    private int price;
    private String store;

    public GroceryItem(String name, int price, String store) {
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getStore() {
        return store;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", store='" + store + '\'' +
                '}';
    }
}
