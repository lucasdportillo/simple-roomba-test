package com.yoti.roomba.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CleanInfoReport {
    private int[] finalPosition;
    private int totalPatches;
}
