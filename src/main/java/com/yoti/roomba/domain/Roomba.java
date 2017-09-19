package com.yoti.roomba.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Queue;

class Roomba {
    @Getter
    @Setter
    private Room room;

    @Getter
    @Setter
    private Queue<Direction> cleaningDirections;

    @Getter
    private int totalPatches = 0;

    @Getter
    private Room.Point finalPosition;

    public Roomba(Room room, Queue<Direction> cleaningDirections) {
        this.room = room;
        this.cleaningDirections = cleaningDirections;
    }

    void startCleaningAt(Room.Point beginning) {
        if (room.withinLimits(beginning)) {
            cleanAt(beginning);
            Room.Point next = beginning;
            for (Direction direction : cleaningDirections) {
                next = room.nextAvailableSpot(next, direction);
                cleanAt(next);
            }
        }
    }

    private void cleanAt(Room.Point point) {
        if (room.isDirtAt(point)) {
            room.removeDirtAt(point);
            totalPatches++;
        }
        finalPosition = point;
    }

}
