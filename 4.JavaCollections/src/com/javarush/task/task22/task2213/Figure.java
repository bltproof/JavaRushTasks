package com.javarush.task.task22.task2213;

public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public void left() {
        x--;
        if (!isCurrentPositionAvailable()) x++;
    }

    public void right() {
        x++;
        if (!isCurrentPositionAvailable()) x--;
    }

    public void up() {
        y--;
    }

    public void down() {
        y++;
    }

    public void rotate() {}

    public void downMaximum() {}

    public boolean isCurrentPositionAvailable() {
        return true;
    }

    public void landed() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}