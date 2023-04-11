package com.mv.week2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class C{

}
class A implements Serializable {
    int a;
    int b;

    C obj;

    A()  {
        this.a = 10;
        this.b = 5;
        this.obj = new C();
    }
}

 class B {
    public static void  main(String[] args) throws IOException {

        try {
            A objA = new  A();

            //Creating stream and writing the object
            FileOutputStream fout = new  FileOutputStream("file.txt");

            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(objA);
            out.flush();
            out.close();

            System.out.println("Serialization successful");
        }

        catch(Exception e)  {
            System.out.println(e);
        }
    }
}


public class SerializationDemo {
}
