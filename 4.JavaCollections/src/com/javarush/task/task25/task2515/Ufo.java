package com.javarush.task.task25.task2515;

import java.util.Random;

public class Ufo extends BaseObject {
    private static int[][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
    };

    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void move() {
        x = x + (Math.random() * 2 - 1);
        y = y + (Math.random() * 2 - 1);

        checkBorders(radius, Space.game.getWidth() - radius + 1, radius - 1, Space.game.getHeight() / 2 - 1);

        if (new Random().nextInt(100) < 10) fire();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }

    public void fire() {
        Space.game.getBombs().add(new Bomb(x, y + radius));
    }
}