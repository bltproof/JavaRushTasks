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
                break;
            case DOWN:
                move(0, 1);
                break;
            case LEFT:
                move(-1, 0);
                break;
            case RIGHT:
                move(1, 0);
        }
    }

    public void move(int dx, int dy) {
        int mouseX = Room.game.getMouse().getX();
        int mouseY = Room.game.getMouse().getY();

        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);

        checkBorders(head);
        checkBody(head);

        if (this.isAlive()) {
            if (mouseX == head.getX() && mouseY == head.getY()) {
                sections.add(0, new SnakeSection(mouseX, mouseY));
                Room.game.eatMouse();
            } else {
                sections.add(0, head);
                sections.remove(sections.size() - 1);
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