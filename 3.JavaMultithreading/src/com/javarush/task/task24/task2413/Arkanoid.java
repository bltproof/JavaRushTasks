package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    private int width;
    private int height;

    private Ball ball;
    private Stand stand;

    private List<Brick> bricks;

    static Arkanoid game;

    public Arkanoid(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public void run() {

    }

    public void move() {
        stand.move();
        ball.move();
    }

    public void draw(Canvas canvas) {
        stand.draw(canvas);
        ball.draw(canvas);

        for (Brick brick : bricks) {
            brick.draw(canvas);
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Canvas canvas = new Canvas(2, 4);
        canvas.drawMatrix(3, 5, a, 'c');

        canvas.print();
    }
}
