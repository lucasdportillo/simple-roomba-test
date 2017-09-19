package com.yoti.roomba.domain;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.yoti.roomba.domain.Direction.*;
import static com.yoti.roomba.domain.Room.Point;

import static org.junit.Assert.*;

public class RoombaTest {
    @Test
    public void shouldCreateRoombaOkWithCleaningDirections() {
        Queue<Direction> cleaningDirections = new LinkedList<>();
        Roomba roomba = new Roomba(new Room(5,5), cleaningDirections);

        assertNotNull(roomba.getCleaningDirections());
    }

    @Test
    public void shouldFollow1CleaningDirection() {
        Queue<Direction> cleaningDirections = new LinkedList<>();
        Room room = new Room(5, 5);

        Point point = new Point(0,0);
        room.setDirtAt(point);
        room.setDirtAt(point.from(E));

        Roomba roomba = new Roomba(room, cleaningDirections);

        cleaningDirections.add(E);
        roomba.startCleaningAt(point);

        assertFalse(room.isDirtAt(point));
        assertFalse(room.isDirtAt(point.from(E)));
    }

    @Test
    public void givenDirtyRoomRoombaShouldClean1Row() {
        Room room = new Room(2, 2);

        Point start = new Point(0,1);
        room.setDirtAt(start);
        room.setDirtAt(start.from(E));

        Queue<Direction> cleaningDirections = new LinkedList<>();
        cleaningDirections.add(N);
        cleaningDirections.add(N);
        cleaningDirections.add(E);
        cleaningDirections.add(E);
        cleaningDirections.add(E);

        Roomba roomba = new Roomba(room, cleaningDirections);

        roomba.startCleaningAt(start);

        assertFalse(room.isDirtAt(start));
        assertFalse(room.isDirtAt(start.from(E)));
    }


}
