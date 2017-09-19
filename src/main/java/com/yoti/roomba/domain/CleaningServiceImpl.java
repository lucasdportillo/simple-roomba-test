package com.yoti.roomba.domain;

import org.springframework.stereotype.Service;

@Service
public class CleaningServiceImpl extends CleaningServiceTemplate {

    public CleanInfoReport doCleaning(CleanInfoRequest request) {
        CleanInfoReport report = new CleanInfoReport();
        Roomba roomba = request.getRoomba();

        roomba.startCleaningAt(request.getStartPosition());

        report.setFinalPosition(roomba.getFinalPosition().toArray());
        report.setTotalPatches(roomba.getTotalPatches());

        return report;
    }
}
