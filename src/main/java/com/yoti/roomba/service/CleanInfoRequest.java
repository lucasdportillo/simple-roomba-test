package com.yoti.roomba.service;

import com.yoti.roomba.controller.domain.RoombaInputParameter;
import com.yoti.roomba.domain.Direction;
import com.yoti.roomba.domain.Room;
import com.yoti.roomba.domain.Roomba;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Setter
@Getter
public class CleanInfoRequest {

    private Room room;
    private Roomba roomba;
    private Room.Point startPosition;
    private RoombaInputParameter parameter;

    public static CleanInfoRequest from(RoombaInputParameter parameter) {
        CleanInfoRequest cleanInfoRequest = new CleanInfoRequest();
        cleanInfoRequest.setParameter(parameter);

        Room room = readRoomDimensions(parameter);
        room.setDirtAt(readPatchesOfDirt(parameter));
        Queue<Direction> cleaningDirections = readDirections(parameter);

        cleanInfoRequest.setRoom(room);
        cleanInfoRequest.setRoomba(new Roomba(room, cleaningDirections));
        cleanInfoRequest.setStartPosition(readStartPosition(parameter));

        return cleanInfoRequest;
    }

    private static Room.Point[] readPatchesOfDirt(RoombaInputParameter parameter) {
        List<Room.Point> patchList = new LinkedList<>();
        for (int i = 0; i < parameter.getPatches().length; i++) {
            patchList.add(new Room.Point(parameter.getPatches()[i][0], parameter.getPatches()[i][1]));
        }
        return patchList.toArray(new Room.Point[]{});
    }

    private static Room.Point readStartPosition(RoombaInputParameter parameter) {
        return new Room.Point(parameter.getCoordenates()[0], parameter.getCoordenates()[1]);
    }

    private static Queue<Direction> readDirections(RoombaInputParameter parameter) {
        Queue<Direction> cleaningDirections = new LinkedList<>();
        for (int i = 0; i < parameter.getInstructions().length(); i++) {
            cleaningDirections.add(Direction.from(parameter.getInstructions().charAt(i)));
        }
        return cleaningDirections;
    }

    private static Room readRoomDimensions(RoombaInputParameter parameter) {
        return new Room(parameter.getRoomSize()[0], parameter.getRoomSize()[1]);
    }
}
