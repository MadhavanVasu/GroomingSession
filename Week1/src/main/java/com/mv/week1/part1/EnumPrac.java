package com.mv.week1.part1;

//interface

enum Days {

    // Enum constants are public static final constants
    MONDAY {

        public int var = 10;

        public int dummy() {
            var = 5;
            return var;
        }

        public void setVar(int v) {
            var = v;
        }
    },
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    int dayOfTheWeek;

    static {
        System.out.println("In static block");
    }

    // Enum can have only private and default constructors
    private Days(int x) {
        System.out.println("In parameterized constructor " + x);
        this.dayOfTheWeek = x;

    }

    Days() {
        System.out.println("In default constructor");
    }

    // Enum is a final class. So no use creating protected methods as other classes can't inherit.
    public int getDayOfTheWeek() {
        return dayOfTheWeek;
    }

}


public class EnumPrac {
    static Days days;

    public EnumPrac(String s) {
        System.out.println("hi from Enum");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mv.week1.part1.Days");
        // Even if just a single constant is used all the constants are initialized as they are public final static
        Days day = Days.MONDAY;
        System.out.println(day);


//        System.out.println(day.dummy());

        // returns 0-4 = -4
        System.out.println(day.compareTo(Days.FRIDAY));

        String s = day.toString();
        System.out.println(s);

        // ordinal() returns the position of the constant
        System.out.println(day.ordinal());

        // values() method gives an array of enum constants
        for (Days x : Days.values()) {
            System.out.println(x);
        }
        int a = Days.TUESDAY.dayOfTheWeek;
        Days[] daysArr = Days.values();
        System.out.println(daysArr[2]);
        System.out.println(days.MONDAY.dayOfTheWeek);
        System.out.println(day.getDayOfTheWeek());


    }

}

