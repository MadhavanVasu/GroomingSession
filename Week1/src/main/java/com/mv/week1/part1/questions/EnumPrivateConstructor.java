package com.mv.week1.part1.questions;

enum Days {
    MONDAY(1, "Mon"),
    TUESDAY(2, "Tue"),
    WEDNESDAY(3, "Wed"),
    THURSDAY(4, "Thurs"),
    FRIDAY(5, "Fri"),
    SATURDAY(6, "Sat"),
    SUNDAY(7, "Sun");

    private int dayOfTheWeek;
    private String abbreviation;

    // Enum can have only private and default constructors
    private Days(int x, String abbreviation) {
        System.out.println("In private parameterized constructor " + x);
        this.dayOfTheWeek = x;
        this.abbreviation = abbreviation;
    }
}

public class EnumPrivateConstructor {

    public static void main(String[] args) {

        Days day = Days.MONDAY;

    }

}
