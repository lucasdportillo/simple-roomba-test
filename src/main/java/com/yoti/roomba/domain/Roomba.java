package com.yoti.roomba.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Queue;

@AllArgsConstructor
class Roomba {
    @Getter
    @Setter
    private Room room;

    @Getter
    @Setter
    private Queue<Direction> cleaningDirections;

    void startCleaningAt(Room.Point beginning) {
        if (room.withinLimits(beginning)) {
            room.removeDirtAt(beginning);
            Room.Point next = beginning;
            for (Direction direction: cleaningDirections) {
                next = room.nextAvailableSpot(next, direction);
                room.removeDirtAt(next);
            }
        }
    }
}
