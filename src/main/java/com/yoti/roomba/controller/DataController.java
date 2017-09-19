package com.yoti.roomba.controller;

import com.yoti.roomba.repository.RoombaInput;
import com.yoti.roomba.repository.RoombaInputRepository;
import com.yoti.roomba.repository.RoombaOutput;
import com.yoti.roomba.repository.RoombaOutputRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Setter
public class DataController {
    @Autowired
    private RoombaInputRepository inputRepository;

    @Autowired
    private RoombaOutputRepository outputRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/inputs")
    public List<RoombaInput> getAllInputs() {
        return inputRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/outputs")
    public List<RoombaOutput> getAllOutputs() {
        return outputRepository.findAll();
    }

}
