package com.yoti.roomba.service;

public interface CleaningService {
    CleanInfoReport performCleaning(CleanInfoRequest request);
}
