package com.mv.week5.behavioraldesignpatterns.command;

public class OnCommand implements Command {

    Television television;

    public OnCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.on();
    }

}
