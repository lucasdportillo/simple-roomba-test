package com.yoti.roomba.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class OutputJsonConverter implements AttributeConverter<RoombaOutputData, String> {

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public String convertToDatabaseColumn(RoombaOutputData data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not convert to Json", e);
        }
    }

    @Override
    public RoombaOutputData convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, RoombaOutputData.class);
        } catch (IOException e) {
            throw new RuntimeException("Could not convert from Json", e);
        }
    }
}
