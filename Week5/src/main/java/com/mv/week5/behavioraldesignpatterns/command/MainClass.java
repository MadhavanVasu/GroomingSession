package com.mv.week5.behavioraldesignpatterns.command;

public class MainClass {

    // Command is a behavioral design pattern that turns a request into a stand-alone object
    // that contains all information about the request.

    // It achieves :
    // Single Responsibility Principle - You can decouple classes that invoke operations
    // from classes that perform these operations.
    // Open/Closed Principle - You can introduce new commands into the app without breaking
    // existing client code.
    public static void main(String[] args) {
        Television television = new Television();
        Command command = new OnCommand(television);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(command);
        remoteControl.pressButton();
    }

}
