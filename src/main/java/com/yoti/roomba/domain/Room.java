package com.yoti.roomba.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


class Room {
    @Getter
    private int x, y;
    private boolean[][] placesWithDirt;

    Room(int x, int y) {
        this.x = x;
        this.y = y;
        placesWithDirt = new boolean[x][y];
    }

    boolean isDirtAt(Point point) {
        return placesWithDirt[point.x][point.y];
    }

    void setDirtAt(Point point) {
        placesWithDirt[point.x][point.y] = true;
    }

    boolean canMoveFromTo(Point origin, Point destination) {
        return withinLimits(origin, destination) && origin.nextTo(destination);
    }

    boolean withinLimits(Point... points) {
        for (Point p : points) {
            if (p.x > x - 1 || p.y > y - 1)
                return false;
        }
        return true;
    }

    void removeDirtAt(Point point) {
        placesWithDirt[point.x][point.y] = false;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Point {
        int x, y;

        boolean nextTo(Point other) {
            return Math.abs(x - other.x) <= 1
                    && Math.abs(y - other.y) <= 1;
        }
    }
}
