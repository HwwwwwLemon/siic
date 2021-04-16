package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.NurseContentService;
import com.hwwwww.siic.vo.NurseContent;
import com.hwwwww.siic.vo.NurseLevelContent;
import com.hwwwww.siic.vo.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/16 13:33
 */
@RestController
@RequestMapping("nurse-content")
public class NurseContentController {

    @Autowired
    private NurseContentService service;

    @RespBodyResMapping("/query")
    public Map<String, Object> getNurseContent(@RequestParam Map<String, Object> params) {
        return service.selectNurseContentWithPage(params);
    }

    @RespBodyResMapping("/add")
    public boolean addNurseContent(NurseContent nurseContent) {
        return service.insert(nurseContent);
    }

    @RespBodyResMapping("/update")
    public boolean updateNurseContent(NurseContent nurseContent) {
        return service.update(nurseContent);
    }

    @RespBodyResMapping("/del")
    public boolean deleteNurseContent(Integer id) {
        return service.delete(id);
    }

    @RespBodyResMapping("/get-nurse-content-selector")
    public List<Selector> getNurseContentSelector() {
        return service.selectNurseContentSelector();
    }
}
