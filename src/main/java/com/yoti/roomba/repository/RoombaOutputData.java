package com.yoti.roomba.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoombaOutputData implements Data {
    @JsonProperty(value = "coords")
    private int[] finalPosition;
    private int totalCleanPatches;
}
