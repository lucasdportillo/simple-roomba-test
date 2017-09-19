package com.yoti.roomba.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RoombaInputParameter {
    private int[] roomSize;
    @JsonProperty(value = "coords")
    private int[] coordenates;
    private int[][] patches;
    private String instructions;
}
