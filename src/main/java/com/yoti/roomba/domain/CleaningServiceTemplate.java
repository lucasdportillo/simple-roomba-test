package com.yoti.roomba.domain;

import com.yoti.roomba.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CleaningServiceTemplate implements CleaningService {

    @Override
    public CleanInfoReport performCleaning(CleanInfoRequest request) {
        saveInput(request);
        CleanInfoReport report = doCleaning(request);
        saveReport(report);
        return report;
    }

    public abstract CleanInfoReport doCleaning(CleanInfoRequest request);

    protected void saveInput(CleanInfoRequest request) {

    }

    protected void saveReport(CleanInfoReport report) {

    }
}

