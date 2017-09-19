package com.yoti.roomba.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class RoombaInputParameter {
    @NotNull(message = "Please provide room size")
    private int[] roomSize;

    @NotNull(message = "Please provide coordinates for starting point")
    @JsonProperty(value = "coords")
    private int[] coordenates;

    private int[][] patches;

    @NotEmpty(message = "Please provide instructions")
    private String instructions;
}
