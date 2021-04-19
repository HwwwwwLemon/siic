package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.RetreatService;
import com.hwwwww.siic.vo.Retreat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/19 15:51
 */
@RestController
@RequestMapping("/retreat")
public class RetreatController {
    @Autowired
    private RetreatService service;

    @RespBodyResMapping("/query")
    public Map<String, Object> getRetreats(@RequestParam Map<String, Object> params) throws Exception {
        return service.selectRetreatWithPage(params);
    }

    @RespBodyResMapping("get-by-id")
    public Map<String, Object> getRetreatById(Integer id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("retreat", service.getRetreatById(id));
        return map;
    }

    @RespBodyResMapping("audit")
    public boolean audit(@RequestBody List<Retreat> retreatList) {
        return service.updateAudit(retreatList);
    }

    @RespBodyResMapping("/add")
    public boolean addRetreat(Retreat retreat) throws Exception {
        return service.insert(retreat);
    }

    @RespBodyResMapping("/update")
    public boolean updateRetreat(Retreat retreat) throws Exception {
        return service.update(retreat);
    }

    @RespBodyResMapping("/del")
    public boolean deleteRetreat(Integer id) {
        return service.delete(id);
    }

}
