package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.NurseLevelService;
import com.hwwwww.siic.vo.NurseLevel;
import com.hwwwww.siic.vo.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
        return service.selectNurseLevelWithPage(params);

    }

    @RespBodyResMapping("get-by-id")
    public Map<String, Object> getNurseLevelById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("nurseLevel", service.getById(id));
        return map;
    }

    @RespBodyResMapping("/get-nurse-level")
    public List<Selector> getNurseLevelSelector() throws JsonProcessingException {
        return service.selectNurseLevelSelector();

    }

    @RespBodyResMapping("/add")
    public boolean addNurseLevel(NurseLevel nurseLevel) {
        return service.insert(nurseLevel);
    }

    @RespBodyResMapping("/update")
    public boolean updateNurseLevel(NurseLevel nurseLevel) {
        return service.update(nurseLevel);
    }

    @RespBodyResMapping("/del")
    public boolean deleteNurseLevel(Integer id) {
        return service.delete(id);
    }
}
