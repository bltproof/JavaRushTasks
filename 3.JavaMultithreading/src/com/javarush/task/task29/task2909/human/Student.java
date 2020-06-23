package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setAverageGrade(double value) {
        averageGrade = value;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setCourse(int value) {
        course = value;
    }

    public void setBeginningOfSession(Date date) {
        this.beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        this.endOfSession = date;
    }

    public int getCourse() {
        return course;
    }
}