package com.mv.week1.part2.questions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

final class A {
    private final List<Student> list;
    private final Date date;

    public A(List<Student> list, Date date) {
        this.list = Collections.unmodifiableList(new ArrayList<>(list));
        this.date = new Date(date.getTime());
    }

    public List<Student> getList() {
        return Collections.unmodifiableList(new ArrayList<>(list));
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    @Override
    public String toString() {
        return "A{" +
                "list=" + list +
                ", date=" + date +
                '}';
    }
}


public class ImmutableClass {

    public static void main(String[] args) throws ParseException {
//        List<String> stringList = new ArrayList<>(List.of("hi","hello"));
        Student student1 = new Student("Madhavan", 22);
        Student student2 = new Student("Vijay", 25);
        List<Student> studentList = new ArrayList<>() {
            {
                add(student1);
                add(student2);
            }
        };
        SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = s1.parse("26/09/2000");
        A obj = new A(studentList, date);
        System.out.println(obj);

        Student student = obj.getList().get(0);
        student.setAge(23);
        System.out.println(student);
        // List cannot be modified but the object can be modified
        System.out.println(studentList);

        // Throws UnsupportedOperationException as immutable objects cannot be modified
        obj.getList().remove(0);

    }


}
