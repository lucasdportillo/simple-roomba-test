package com.yoti.roomba.service;

import com.yoti.roomba.repository.RoombaInput;
import com.yoti.roomba.repository.RoombaInputRepository;
import com.yoti.roomba.repository.RoombaOutput;
import com.yoti.roomba.repository.RoombaOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CleaningServiceTemplate implements CleaningService {

    @Autowired
    private RoombaInputRepository roombaInputRepository;

    @Autowired
    private RoombaOutputRepository roombaOutputRepository;

    @Override
    public CleanInfoReport performCleaning(CleanInfoRequest request) {
        saveInput(request);
        CleanInfoReport report = doCleaning(request);
        saveReport(report);
        return report;
    }

    public abstract CleanInfoReport doCleaning(CleanInfoRequest request);

    protected void saveInput(CleanInfoRequest cleanInfoRequest) {
        roombaInputRepository.save(RoombaInput.from(cleanInfoRequest));
    }

    protected void saveReport(CleanInfoReport cleanInfoReport) {
        roombaOutputRepository.save(RoombaOutput.from(cleanInfoReport));
    }
}

