package com.mv.week5.creationaldesignpatterns.prototype;

public class Rectangle implements Shape {


    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }


}
