package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        setBoarderColor(decoratedShape);
        super.draw();
    }

    private void setBoarderColor(Shape shape) {
        System.out.println(String.format("Setting border color for %s to red.", shape.getClass().getSimpleName()));
    }
}