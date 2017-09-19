package com.yoti.roomba.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CleanInfoReport {
    private int[] finalPosition;
    private int totalPatches;
}
