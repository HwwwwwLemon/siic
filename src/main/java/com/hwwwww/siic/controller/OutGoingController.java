package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.OutgoingService;
import com.hwwwww.siic.vo.OutGoing;
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
 * @date 2021/4/17 22:33
 */
@RestController
@RequestMapping("/out-going")
public class OutGoingController {
    @Autowired
    private OutgoingService service;

    @RespBodyResMapping("/query")
    public Map<String, Object> getOutGoings(@RequestParam Map<String, Object> params) throws Exception {
        return service.selectOutGoingWithPage(params);
    }

    @RespBodyResMapping("get-by-id")
    public Map<String, Object> getOutGoingById(Integer id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("outgoing", service.getOutGoingById(id));
        return map;
    }

    @RespBodyResMapping("audit")
    public boolean audit(@RequestBody List<OutGoing> outGoingList) {
        return service.updateAudit(outGoingList);
    }

    @RespBodyResMapping("/add")
    public boolean addOutGoing(OutGoing outGoing) throws Exception {
        return service.insert(outGoing);
    }

    @RespBodyResMapping("/update")
    public boolean updateOutGoing(OutGoing outGoing) throws Exception {
        return service.update(outGoing);
    }

    @RespBodyResMapping("/del")
    public boolean deleteOutGoing(Integer id) {
        return service.delete(id);
    }

}
