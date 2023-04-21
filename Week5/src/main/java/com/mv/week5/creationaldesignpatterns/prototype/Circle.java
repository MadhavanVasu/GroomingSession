package com.mv.week5.creationaldesignpatterns.prototype;

public class Circle implements Shape {


    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
