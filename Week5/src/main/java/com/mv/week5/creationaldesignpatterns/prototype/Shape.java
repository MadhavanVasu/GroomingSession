package com.mv.week5.creationaldesignpatterns.prototype;

public interface Shape extends Cloneable {

    public Shape clone() throws CloneNotSupportedException;

    public void draw();

}