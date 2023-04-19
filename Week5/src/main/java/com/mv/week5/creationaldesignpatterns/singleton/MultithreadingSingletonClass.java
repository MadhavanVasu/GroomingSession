package com.mv.week5.creationaldesignpatterns.singleton;

public class MultithreadingSingletonClass {

    // Have to use volatile keyword here. Otherwise, double-checking dangerous
    // Because it can lead to racing condition.
    private static volatile MultithreadingSingletonClass obj = null;
    private String name;

    private MultithreadingSingletonClass() {

    }

    private MultithreadingSingletonClass(String name) {
        this.name = name;

    }

    public String getName() {
        return this.name;
    }

    public static synchronized MultithreadingSingletonClass getInstanceSynchronizedMethod() {
        if (obj == null)
            obj = new MultithreadingSingletonClass();
        return obj;
    }

    public static MultithreadingSingletonClass getInstanceSynchronizedBlock() {
        // Here we do double-checking
        if (obj == null) {
            synchronized (MultithreadingSingletonClass.class) {
                if (obj == null)
                    obj = new MultithreadingSingletonClass(Thread.currentThread().getName());
            }
        }
        return obj;
    }

}


class MultithreadingSingletonDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            MultithreadingSingletonClass obj = MultithreadingSingletonClass.getInstanceSynchronizedBlock();
            System.out.println(obj.getName());
        });
        Thread t2 = new Thread(() -> {
            MultithreadingSingletonClass obj = MultithreadingSingletonClass.getInstanceSynchronizedBlock();
            System.out.println(obj.getName());
        });

        t1.start();
        t2.start();
    }

}