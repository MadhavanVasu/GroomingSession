package com.mv.week1.part2.questions.solid;

class PersonalComputer {

    Monitor monitor;
    Keyboard keyboard;

    public PersonalComputer() {

    }

    public PersonalComputer(Monitor monitor, Keyboard keyboard) {
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

}

interface Monitor {

    public void displayMessage();

}

interface Keyboard {


}

class ZebronicsKeyboard implements Keyboard {

}

class HPMonitor implements Monitor {

    @Override
    public void displayMessage() {
        System.out.println("Hello World");
    }
}

public class DependencyInversion {

    Monitor monitor = new HPMonitor();
    Keyboard keyboard = new ZebronicsKeyboard();
    // Higher level module (Personal Computer) should not depend on lower level modules
    // like HPMonitor, Zebronics Keyboard.
    // Instead, both should depend on abstraction.
    // i.e. here they depend on Monitor and Keyboard interfaces.
    PersonalComputer pc = new PersonalComputer(monitor, keyboard);

}
