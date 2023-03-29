package com.mv.week1.part2.questions.solid;

interface Printer {

    void print(String message);

    String scan(String message);

    void fax(String message);

}

class EPSONPrinter implements Printer {

    // EPSON Printer needs only print functionality
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    // It should not be forced to implement other abstract methods.
    @Override
    public String scan(String message) {
        return null;
    }

    @Override
    public void fax(String message) {

    }
}

// 4 . I - Interface Segregation
interface Printable {
    void print(String message);
}

interface Scannable {
    String scan(String message);
}

interface Faxable {
    void fax(String message);
}

class EPSONEcoTankPrinter implements Printable {

    // EPSON EcoTank Printer is an old model printer and has only print functionality.
    // So it can implement the Printable interface alone.
    // It doesn't have to implement unnecessary methods as it was in previous example.
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}

class HPDeskJetPrinter implements Printable, Scannable {

    // HP Desk Jet Printer has both printing and scanning functionality
    // So it can implement both the interfaces.
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String scan(String message) {
        return message;
    }
}

public class InterfaceSegregation {

    public static void main(String[] args) {
        Printer printer = new EPSONPrinter();
        printer.print("Hello World");
        printer.scan("Hello World");
        printer.fax("Hello World");

        Printable printer2 = new EPSONEcoTankPrinter();
        printer2.print("Hello World");

        HPDeskJetPrinter printer3 = new HPDeskJetPrinter();
        printer3.print("Hello World");
        printer3.scan("Hello World");
    }
}
