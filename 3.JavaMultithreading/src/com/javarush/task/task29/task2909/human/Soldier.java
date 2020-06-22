package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {

    private int bloodGroup;

    public Soldier(String name, int age) {
        super(name, age);

    }

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    @Override
    public void live() {
        fight();
    }

    public void fight() {

    }
}
