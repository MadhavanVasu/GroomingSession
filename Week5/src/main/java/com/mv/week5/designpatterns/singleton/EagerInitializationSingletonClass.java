package com.mv.week5.designpatterns.singleton;

public class EagerInitializationSingletonClass {

    // In eager initialization, the instance of the singleton class is created at the time of class loading.
    // The drawback to eager initialization is that the method is created even though
    // the client application might not be using it.

    private static final EagerInitializationSingletonClass obj = new EagerInitializationSingletonClass();

    // Another way of eager initialization
//    static {
//        obj = new EagerLoadingSingletonClass();
//    }
    private EagerInitializationSingletonClass() {

    }

    public static EagerInitializationSingletonClass getInstance() {
        // It enough if we just return the object here.
        // Don't have to perform any checks
        return obj;
    }

}

class EagerInitializationDemo {
    public static void main(String[] args) {
        EagerInitializationSingletonClass obj1 = EagerInitializationSingletonClass.getInstance();
        EagerInitializationSingletonClass obj2 = EagerInitializationSingletonClass.getInstance();

        // Prints the same hashCode value as same object is returned everytime.
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }
}
