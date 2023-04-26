package com.mv.week5.behavioraldesignpatterns.command;

public class OffCommand implements Command {

    Television television;

    public OffCommand(Television television) {
        this.television = television;
    }

    public void execute() {
        television.off();
    }

}
