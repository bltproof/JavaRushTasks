package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
    public static int nextId = 0;
    private int id;
    private int bloodGroup;

    public Soldier(String name, int age) {
        super(name, age);
        this.id = nextId;
        nextId++;
    }

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void live() {
        fight();
    }

    public void fight() {

    }
}
