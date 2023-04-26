package com.mv.week5.behavioraldesignpatterns.command;

public class MainClass {

    public static void main(String[] args) {
        Television television = new Television();
        Command command = new OnCommand(television);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(command);
        remoteControl.pressButton();
    }

}
