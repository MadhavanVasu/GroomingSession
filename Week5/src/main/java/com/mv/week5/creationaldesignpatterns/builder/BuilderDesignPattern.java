package com.mv.week5.creationaldesignpatterns.builder;

enum Year {
    FIRST,
    SECOND,
    THIRD,
    FOURTH
}

enum Gender {
    MALE,
    FEMALE
}

class Student {

    private int studentId;
    private String name;
    private String dept;
    private Year year;
    private String section;
    private Gender gender;

    private Student(StudentBuilder studentBuilder) {
        this.studentId = studentBuilder.studentId;
        this.name = studentBuilder.name;
        this.dept = studentBuilder.dept;
        this.year = studentBuilder.year;
        this.section = studentBuilder.section;
        this.gender = studentBuilder.gender;
    }

    public static class StudentBuilder {
        // Required parameters
        private int studentId;
        private String name;
        private String dept;

        // Optional parameters
        private Year year;
        private String section;
        private Gender gender;

        public StudentBuilder(int studentId, String name, String dept) {
            this.studentId = studentId;
            this.name = name;
            this.dept = dept;
        }

        public StudentBuilder year(Year year) {
            this.year = year;
            return this;
        }

        public StudentBuilder section(String section) {
            this.section = section;
            return this;
        }


        public StudentBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", year=" + year +
                ", section='" + section + '\'' +
                ", gender=" + gender +
                '}';
    }
}
// Builder is a creational design pattern that lets you construct complex objects step by step.
// The pattern allows you to produce different types
// and representations of an object using the same construction code.

// In most cases, one uses a builder pattern because one wants to keep the object — once created — immutable.
// That is, create it, and never change it again.
// Immutable objects are useful for multiple reasons (beyond the scope of this answer),
// but mostly so that you know you can keep using them without the inner data changing unexpectedly.
//Immutable objects do not, by definition, support changes, and the associated class
// does not have setter methods.

// A builder pattern ensures we create a valid object to work with.
//Let's use a Person class as an example.
// If we opt for the no-args constructor approach it means users of those objects must
// check the validity of the object; has the name field been set? Has the DOB field been set?
// The list goes on.
//So instead we use a PersonBuilder that won't allow a Person object to be
// constructed without all the required attributes.

// Most of the time, the builder pattern is used to build an immutable object.
// The builder builds an object, and you want the built object to be mutable, then it can have setters.
public class BuilderDesignPattern {

    public static void main(String[] args) {
        Student student = new Student.StudentBuilder(26, "Maddy", "IT").section("A").year(Year.FOURTH).build();
        System.out.println(student);
    }
}
