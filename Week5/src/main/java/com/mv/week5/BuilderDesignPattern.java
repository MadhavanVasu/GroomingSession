package com.mv.week5;

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

public class BuilderDesignPattern {

    public static void main(String[] args) {
        Student student = new Student.StudentBuilder(26, "Maddy", "IT").section("A").year(Year.FOURTH).build();
        System.out.println(student);
    }
}
