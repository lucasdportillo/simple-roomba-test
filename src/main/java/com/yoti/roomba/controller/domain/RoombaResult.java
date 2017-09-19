package com.yoti.roomba.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yoti.roomba.domain.CleanInfoReport;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoombaResult {
    @JsonProperty(value = "coords")
    private int[] finalPosition;
    private int totalCleanPatches;

    public RoombaResult(CleanInfoReport cleanInfoReport) {
        this.finalPosition = cleanInfoReport.getFinalPosition();
        this.totalCleanPatches = cleanInfoReport.getTotalPatches();
    }
}
