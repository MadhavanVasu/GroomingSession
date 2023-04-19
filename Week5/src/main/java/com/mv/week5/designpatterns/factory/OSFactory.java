package com.mv.week5.designpatterns.factory;

public class OSFactory {

    public OperatingSystem getOperatingSystem(OSAbstractFactory osAbstractFactory) {
        return osAbstractFactory.createOS();
    }

}
