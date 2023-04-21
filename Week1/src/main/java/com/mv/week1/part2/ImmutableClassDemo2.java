package com.mv.week1.part2;


import java.util.ArrayList;
import java.util.List;

final class Classroom {

    private final Integer classId;
    private final List<Student> students;

    public Classroom(Integer classId, List<Student> students) {
        this.classId = classId;
        this.students = new ArrayList<>(students);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classId=" + classId +
                ", students=" + students +
                '}';
    }

    public int getClassId() {
        return this.classId;
    }

}

public class ImmutableClassDemo2 {

    public static void main(String[] args) {

        Student s1 = new Student(1, "Maddy");
        Student s2 = new Student(2, "Vijay");
        List<Student> list = new ArrayList<>() {
            {
                add(s1);
                add(s2);
            }
        };
        Classroom obj = new Classroom(1, list);
//        System.out.println(obj.getClassId());
//        System.out.println(obj.getStudents());

        List<Student> list2 = obj.getStudents();
        list2.get(0).name = "Madhavan";

        // So if we return a copy of list, the list won't be modified like clearing the list, removing an object.
        // But the object in the list can be modified which will also get reflected in the actual list.
        // But we need care only about the type of the property
        // i.e. List<Student> means we only need to care about making the List immutable not the object it contains.
        System.out.println(list2);
        System.out.println(obj.getStudents());

        // Note that final only forbids us from changing the reference the variable holds,
        // it doesn't protect us from changing the internal state of the object it refers to
        // by using its public API:
        final List<String> strings = new ArrayList<>();
        strings.add("baeldung");


    }

}
