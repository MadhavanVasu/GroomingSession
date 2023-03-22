package com.mv.week1.part1;

enum Days {

    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday

}

public class EnumPrac {

    public static void main(String[] args) {
        Days day = Days.Monday;
        System.out.println(day);

        // returns 0-4 = -4
        System.out.println(day.compareTo(Days.Friday));

        String s = day.toString();
        System.out.println(s);

        // ordinal() returns the position of the constant
        System.out.println(day.ordinal());

        // values() method gives an array of enum constants
        for (Days x : Days.values()) {
            System.out.println(x);
        }


    }

}
