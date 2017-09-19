package com.yoti.roomba.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


public class Room {
    @Getter
    private int x, y;
    private boolean[][] placesWithDirt;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        placesWithDirt = new boolean[x][y];
    }

    boolean isDirtAt(Point point) {
        return placesWithDirt[point.x][point.y];
    }

    public void setDirtAt(Point... points) {
        for (Point p : points) {
            if (withinLimits(p)) {
                placesWithDirt[p.x][p.y] = true;
            }
        }
    }

    boolean canMoveFromTo(Point origin, Point destination) {
        return withinLimits(origin, destination) && origin.isNextTo(destination);
    }

    boolean withinLimits(Point... points) {
        for (Point p : points) {
            if (p.x < 0 || p.y < 0)
                return false;
            if (p.x > x - 1 || p.y > y - 1)
                return false;
        }
        return true;
    }

    void removeDirtAt(Point point) {
        placesWithDirt[point.x][point.y] = false;
    }

    Point nextAvailableSpot(Point point, Direction direction) {

        Point nextPoint = point.from(direction);

        if (!withinLimits(nextPoint)) {
            return point;
        }

        return nextPoint;
    }

    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class Point {
        private int x, y;

        boolean isNextTo(Point other) {
            return Math.abs(x - other.x) <= 1
                    && Math.abs(y - other.y) <= 1;
        }

        Point from(Direction direction) {
            Point nextPoint = new Point(0, 0);
            switch (direction) {
                case N:
                    return new Point(x, y + 1);
                case S:
                    return new Point(x, y - 1);
                case E:
                    return new Point(x + 1, y);
                case W:
                    return new Point(x - 1, y);
            }
            return nextPoint;
        }

        public int[] toArray() {
            return new int[]{
                    x, y
            };
        }
    }
}
