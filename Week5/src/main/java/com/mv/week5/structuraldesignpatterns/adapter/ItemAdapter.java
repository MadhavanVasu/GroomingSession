package com.mv.week5.structuraldesignpatterns.adapter;

public class ItemAdapter implements Item {

    private GroceryItem item;

    public ItemAdapter(GroceryItem item) {
        this.item = item;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public int getPrice() {
        return item.getPrice();
    }

    @Override
    public String getRestaurant() {
        return item.getStore();
    }

    @Override
    public String toString() {
        return "ItemAdapter{" +
                "item=" + item +
                '}';
    }
}
