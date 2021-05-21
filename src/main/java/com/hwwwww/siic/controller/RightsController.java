package com.hwwwww.siic.controller;

import com.hwwwww.siic.service.RightsService;
import com.hwwwww.siic.vo.Rights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rights")
public class RightsController {

    @Autowired
    RightsService service;

    @RequestMapping("/getallrights")
    public List<Rights> getallRights() {
        return service.getallRights();
    }
}
