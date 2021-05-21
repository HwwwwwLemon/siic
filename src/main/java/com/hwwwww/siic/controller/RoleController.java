package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.RoleService;
import com.hwwwww.siic.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @RespBodyResMapping("/getall")
    public List<Role> getroles() {
        return service.getroles();
    }


}
