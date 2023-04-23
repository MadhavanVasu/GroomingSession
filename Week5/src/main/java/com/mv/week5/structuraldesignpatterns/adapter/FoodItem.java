package com.mv.week5.structuraldesignpatterns.adapter;

public class FoodItem implements Item {

    private String name;

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", restaurant='" + restaurant + '\'' +
                '}';
    }

    private int price;
    private String restaurant;

    public FoodItem(String name, int price, String restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getRestaurant() {
        return restaurant;
    }
}
