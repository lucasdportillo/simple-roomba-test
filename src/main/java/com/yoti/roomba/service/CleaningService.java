package com.yoti.roomba.service;

import com.yoti.roomba.domain.CleanInfoReport;
import com.yoti.roomba.domain.CleanInfoRequest;

public interface CleaningService {
    CleanInfoReport performCleaning(CleanInfoRequest request);
}
