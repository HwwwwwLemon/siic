package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.NurseLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/15 21:56
 */
@RestController
@RequestMapping("nurse-level")
public class NurseLevelController {
    @Autowired
    private NurseLevelService service;

    @RespBodyResMapping("/query")
    public Map<String, Object> getAllCustomers(@RequestParam Map<String, Object> params) throws JsonProcessingException {
        return service.selectCustomerWithPage(params);

    }
}
