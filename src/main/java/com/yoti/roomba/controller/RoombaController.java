package com.yoti.roomba.controller;

import com.yoti.roomba.controller.domain.RoombaInputParameter;
import com.yoti.roomba.controller.domain.RoombaResult;
import com.yoti.roomba.service.CleanInfoReport;
import com.yoti.roomba.service.CleanInfoRequest;
import com.yoti.roomba.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RoombaController {

    @Autowired
    private CleaningService cleaningService;

    @RequestMapping(method = RequestMethod.PUT, path = "/startRoomba")
    public RoombaResult start(@Valid @RequestBody RoombaInputParameter roombaInputParameter) {

        CleanInfoReport cleanInfoReport =
                cleaningService.performCleaning(CleanInfoRequest.from(roombaInputParameter));

        return new RoombaResult(cleanInfoReport);
    }
}
