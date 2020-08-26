package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {
    private Shape shape;

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.shape = decoratedShape;
    }

    private void setBorderColor(Shape shape) {
        System.out.println(String.format("Setting the border color for %s to red.", shape.getClass().getSimpleName()));

    }

    @Override
    public void draw() {
        setBorderColor(shape);
        super.draw();
    }
}