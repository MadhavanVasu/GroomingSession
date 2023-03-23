package com.mv.week1.part1.questions;

enum Days {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int dayOfTheWeek;

    // Enum can have only private and default constructors
    private Days(int x) {
        System.out.println("In private parameterized constructor " + x);
        this.dayOfTheWeek = x;
    }


}

public class EnumPrivateConstructor {

    public static void main(String[] args) {

        Days day = Days.MONDAY;

    }

}
