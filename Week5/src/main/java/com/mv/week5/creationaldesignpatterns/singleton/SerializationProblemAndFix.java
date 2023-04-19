package com.mv.week5.creationaldesignpatterns.singleton;

import java.io.*;

public class SerializationProblemAndFix {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Breaking singleton using serialization");
        serializationProblem();
        System.out.println();
        // Can fix this problem by implementing readResolve() method in the class.
        // So it will return the same object everytime during deserialization.
        System.out.println("Fixing the problem in serialization");
        serializationProblemFix();
    }

    public static void serializationProblem() throws IOException, ClassNotFoundException {
        LazySingletonClass obj = LazySingletonClass.getInstance("Maddy");

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("lazyObject.obj"));
        out.writeObject(obj);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("lazyObject.obj"));
        LazySingletonClass newObj = (LazySingletonClass) in.readObject();
        in.close();

        System.out.println(obj.getName());
        System.out.println(obj.hashCode());
        System.out.println(newObj.getName());
        System.out.println(newObj.hashCode());
    }

    public static void serializationProblemFix() throws IOException, ClassNotFoundException {
        SerializableSingletonClass obj = SerializableSingletonClass.getInstance("Maddy");

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("serializableObj.obj"));
        out.writeObject(obj);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("serializableObj.obj"));
        SerializableSingletonClass newObj = (SerializableSingletonClass) in.readObject();
        in.close();

        System.out.println(obj.getName());
        System.out.println(obj.hashCode());

        System.out.println(newObj.getName());
        System.out.println(newObj.hashCode());

    }

}
