package com.mv.week5.creationaldesignpatterns.singleton;

public class CloneableProblemAndFix {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Clonebale breaks Singleton property");
        clonebaleProblem();
        System.out.println();
        System.out.println("Cloneable problem fix");
        clonebaleProblemFix();
    }

    public static void clonebaleProblem() throws CloneNotSupportedException {
        LazySingletonClass obj = LazySingletonClass.getInstance("Maddy");
        LazySingletonClass cloneObj = (LazySingletonClass) obj.clone();

        System.out.println(obj.hashCode());
        System.out.println(cloneObj.hashCode());
    }

    // To fix Cloneable problem in Singleton, we should either not implement CLoneable interface
    // or throw exception inside overrided clone method.
    public static void clonebaleProblemFix() throws CloneNotSupportedException {
        CloneableSingleton obj = CloneableSingleton.getInstance("Maddy");
        try {
            CloneableSingleton cloneObj = (CloneableSingleton) obj.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone cannot be created");
        }
    }

}
