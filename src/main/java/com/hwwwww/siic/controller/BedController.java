package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/9 15:00
 */
@RestController()
@RequestMapping("/bed")
public class BedController {
    @Autowired
    private BedService service;

    @RespBodyResMapping("/get-room-number")
    public String getRoomNumber() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(service.selectRoomNumber());

    }
    @RespBodyResMapping("/get-bed-number")
    public String getBedNumber(@RequestParam(value = "roomNumber") Integer roomNumber) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(service.selectBedOptions(roomNumber));

    }
}
