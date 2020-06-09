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
            case UP:
                move(0, -1);
            case DOWN:
                move(0, 1);
            case LEFT:
                move(-1, 0);
            case RIGHT:
                move(1, 0);
        }
    }

    public void move(int dx, int dy) {
        int mouseX = Room.game.getMouse().getX();
        int mouseY = Room.game.getMouse().getY();

        checkBorders(sections.get(0));
        checkBody(sections.remove(0));

        if (this.isAlive()) {
            switch (direction) {
                case UP:
                    sections.add(0, new SnakeSection(dx, getY() - dy));
                case DOWN:
                    sections.add(0, new SnakeSection(dx, getY() + dy));
                case LEFT:
                    sections.add(0, new SnakeSection(getX() - dx, dy));
                case RIGHT:
                    sections.add(0, new SnakeSection(getX() + dx, dy));
                default:
                    sections.remove(sections.size() - 1);
            }
            if (mouseX == sections.get(0).getX() && mouseY == sections.get(0).getY()) {
                sections.add(0, new SnakeSection(mouseX, mouseY));
                Room.game.eatMouse();
            }
        }
    }

    public void checkBorders(SnakeSection head) {
        if ((head.getX() < 0 || head.getY() < 0) || (head.getX() >= Room.game.getWidth() || head.getY() >= Room.game.getHeight())) {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head) {
        if (sections.contains(head)) isAlive = false;
    }
}