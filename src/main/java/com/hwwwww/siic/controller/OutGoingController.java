package com.hwwwww.siic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.OutgoingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/17 22:33
 */
@RestController
@RequestMapping("/out-going")
public class OutGoingController {
    @Autowired
    private OutgoingService service;

    @RespBodyResMapping("/query")
    public Map<String, Object> getUsers(@RequestParam Map<String, Object> params) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = service.selectOutGoingWithPage(params);
        System.out.println(map);
        return map;
    }
}
