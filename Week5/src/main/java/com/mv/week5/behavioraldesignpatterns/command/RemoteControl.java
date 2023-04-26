package com.mv.week5.behavioraldesignpatterns.command;

// Invoker
public class RemoteControl {

    Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}
