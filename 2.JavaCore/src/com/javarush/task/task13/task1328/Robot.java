package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public Robot(String name) {
        this.name = name;
    }

    public BodyPart attack() {
        return super.attack();
    }

    public BodyPart defense() {
       return super.defense();
    }
}
