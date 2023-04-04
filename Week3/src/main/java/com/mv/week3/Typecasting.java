package com.mv.week3;

class Parent {

    String name;


    public Parent() {
        System.out.println("Hi from Parent constructor");
        this.name = "Parent Name";
    }

    public void display() {
        System.out.println("Hi from parent");
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Child extends Parent {
    int age;
    String s;

    public Child() {
        System.out.println("Hi from Child constructor");
        age = 10;
    }

    @Override
    public String toString() {
        return "Child{" +
                "age=" + age +
                ", s='" + s + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void display() {
        System.out.println("Hi from child");
    }
}


public class Typecasting {

    public static void main(String[] args) {
        Child child1 = new Child();
        child1.age = 22;
        child1.name = "Maddy";
        System.out.println(child1);
        child1.display();
        Parent p1 = child1;
        System.out.println(p1);
        p1.display();
        Child c2 = (Child) p1;
        System.out.println(c2.age);

        Parent p2 =  new Child();
        System.out.println(p2);

    }

}
