package com.mv.week1.part1.questions.association;

import java.util.List;

class Student {
    int sid;
    List<Course> courses;

    public Student(int sid) {
        this.sid = sid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

class Course {

    int courseId;

    public Course(int courseId, List<Student> students) {
        this.courseId = courseId;
        this.students = students;
    }

    List<Student> students;

}

public class ManyToManyAssociation {

    public static void main(String[] args) {

        // A student can enroll to many courses
        // A course can have many students enrolled
        // This is many to many association

        Student student = new Student(1);
        Course course = new Course(1, List.of(student));
        student.setCourses(List.of(course));
    }


}
