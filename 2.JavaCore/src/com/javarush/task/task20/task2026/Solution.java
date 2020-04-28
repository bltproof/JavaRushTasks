package com.javarush.task.task20.task2026;

import java.util.*;
import java.util.stream.Collectors;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {

        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int shapeCounter = 0;
        Map<Point, Integer> mapping = new HashMap<Point, Integer>();

        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                byte b = a[i][j];

                Point point = new Point(i, j);
                if (b == 1) {
                    Integer shape = getShape(a, point, mapping);
                    if (shape == null) {
                        shape = ++shapeCounter;
                    }
                    mapping.put(point, shape);
                }
            }
        }

        return shapeCounter;
    }

    private static Integer getShape(byte[][] area, Point point, Map<Point, Integer> mapping) {
        List<Point> border = point.getBorder(area);

        for (Point p : border) {
            Integer shape = mapping.get(p);
            if (shape != null) {
                return shape;
            }
        }
        return null;
    }


    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point left() {
            return new Point(x - 1, y);
        }

        public Point right() {
            return new Point(x + 1, y);
        }

        public Point up() {
            return new Point(x, y - 1);
        }

        public Point down() {
            return new Point(x, y + 1);
        }

        public boolean accept(byte[][] area) {
            if (x < 0 || x > area.length - 1) {
                return false;
            }

            if (y < 0 || y > area.length - 1) {
                return false;
            }

            return true;
        }

        public List<Point> getBorder(byte[][] area) {
            List<Point> list = new ArrayList<>();
            list.add(left());
            list.add(left().up());
            list.add(up());
            list.add(right().up());
            list.add(right());
            list.add(right().down());
            list.add(down());
            list.add(left().down());

            return list.stream().filter(point -> point.accept(area)).collect(Collectors.toList());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}