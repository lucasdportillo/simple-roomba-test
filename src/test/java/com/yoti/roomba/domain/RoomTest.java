package com.yoti.roomba.domain;

import org.junit.Test;

import static com.yoti.roomba.domain.Room.Point;
import static org.junit.Assert.*;

public class RoomTest {
    @Test
    public void shouldCreateRoomWithXYDimensions() {
        Room room = new Room(5, 5);

        assertEquals(5, room.getX());
        assertEquals(5, room.getY());
    }

    @Test
    public void shouldPlaceDirtAcrossRoom() {
        Room room = new Room(2, 2);

        room.setDirtAt(new Point(0, 0));
        room.setDirtAt(new Point(1, 1));

        assertTrue(room.isDirtAt(new Point(0, 0)));
        assertTrue(room.isDirtAt(new Point(1, 1)));
        assertFalse(room.isDirtAt(new Point(0, 1)));
        assertFalse(room.isDirtAt(new Point(1, 0)));
    }

    @Test
    public void shouldReturnAbleToMoveFromXXToYY() {
        Room room = new Room(5, 5);

        Point origin = new Point(1, 1);
        Point destination = new Point(1, 2);

        assertTrue(room.canMoveFromTo(origin, destination));
        assertFalse(room.canMoveFromTo(origin, new Point(3, 3)));
        assertFalse(room.canMoveFromTo(origin, new Point(5, 5)));
    }

    @Test
    public void shouldValidatePointsWithinRoomLimits() {
        Room room = new Room(2, 2);

        assertFalse(room.withinLimits(new Point(2, 2), new Point(3, 3), new Point(2, 3)));
        assertTrue(room.withinLimits(new Point(0, 1), new Point(1, 1), new Point(1, 0)));
    }

    @Test
    public void shouldRemoveDirtOnDemand() {
        Room room = new Room(2, 2);
        Point point = new Point(1,0);
        room.setDirtAt(point);

        assertTrue(room.isDirtAt(point));
        room.removeDirtAt(point);
        assertFalse(room.isDirtAt(point));
    }
}
