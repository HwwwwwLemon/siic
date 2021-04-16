package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.NurseLevelContentService;
import com.hwwwww.siic.vo.NurseLevelContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/16 11:10
 */
@RestController
@RequestMapping("nurse-level-content")
public class NurseLevelContentController {
    @Autowired
    private NurseLevelContentService service;

    @RespBodyResMapping("/query")
    public Map<String, Object> getAllCustomers(@RequestParam Map<String, Object> params) throws JsonProcessingException {
        return service.selectNurseLevelContentByNurseLevelId(params);

    }

    @RespBodyResMapping("get-by-id")
    public Map<String, Object> getNurseLevelById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("nurseLevelContent", service.getById(id));
        return map;
    }

    @RespBodyResMapping("/add")
    public boolean addNurseLevelContent(NurseLevelContent nurseLevelContent) {
        return service.insert(nurseLevelContent);
    }

    @RespBodyResMapping("/update")
    public boolean updateNurseLevelContent(NurseLevelContent nurseLevelContent) {
        return service.update(nurseLevelContent);
    }

    @RespBodyResMapping("/del")
    public boolean deleteNurseLevelContent(Integer id) {
        return service.delete(id);
    }
}
