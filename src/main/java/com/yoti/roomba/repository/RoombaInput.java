package com.yoti.roomba.repository;

import com.yoti.roomba.service.CleanInfoRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "roomba_input")
public class RoombaInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Convert(converter = InputJsonConverter.class)
    @Column(name = "data")
    private RoombaInputData data;

    public RoombaInput() {
    }

    public static RoombaInput from(CleanInfoRequest cleanInfoRequest) {
        RoombaInput input = new RoombaInput();
        RoombaInputData data = new RoombaInputData();

        input.setData(data);

        data.setCoordenates(cleanInfoRequest.getParameter().getCoordenates());
        data.setInstructions(cleanInfoRequest.getParameter().getInstructions());
        data.setPatches(cleanInfoRequest.getParameter().getPatches());
        data.setRoomSize(cleanInfoRequest.getParameter().getRoomSize());

        return input;
    }
}
