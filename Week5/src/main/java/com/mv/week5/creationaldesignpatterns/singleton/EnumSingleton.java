package com.mv.week5.creationaldesignpatterns.singleton;

public enum EnumSingleton {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    int dayOfTheWeek;

    private EnumSingleton(int day) {
        this.dayOfTheWeek = day;
    }

    public int getDayOfTheWeek() {
        return MONDAY.ordinal() + 1;
    }

}
