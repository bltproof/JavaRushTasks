package com.javarush.task.task29.task2909.human;

import java.util.List;

public class University {
    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        return students.stream().filter(student -> student.getAverageGrade() == averageGrade).findFirst().get();
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return students.stream().max((o1, o2) -> o1.getAverageGrade() > o2.getAverageGrade() ? 1 : -1).get();
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        return students.stream().max((o1, o2) -> o1.getAverageGrade() < o2.getAverageGrade() ? 1 : -1).get();
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}