package com.yoti.roomba.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class RoombaInputData implements Data {
    private int[] roomSize;
    @JsonProperty(value = "coords")
    private int[] coordenates;
    private int[][] patches;
    private String instructions;
}
