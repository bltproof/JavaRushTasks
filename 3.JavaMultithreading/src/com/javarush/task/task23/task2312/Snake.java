package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        SnakeSection head = new SnakeSection(x, y);
        sections.add(head);
        isAlive = true;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return this.sections.get(0).getX();
    }

    public int getY() {
        return this.sections.get(0).getY();
    }

    public void move() {
        if (!isAlive()) return;
        switch (direction) {
            case UP: move(0, -1);
            case RIGHT: move(1, 0);
            case DOWN: move(0, 1);
            case LEFT: move(-1, 0);
        }
    }

    public void move(int x, int y) {
    }
}