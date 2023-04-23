package com.mv.week5.structuraldesignpatterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class Swiggy {

    private List<Item> items;

    public Swiggy() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

}
