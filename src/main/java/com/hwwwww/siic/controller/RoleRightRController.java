package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.RoleRightRService;
import com.hwwwww.siic.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roleRightR")
public class RoleRightRController {
    @Autowired
    RoleRightRService service;


    @RequestMapping("del")
    public Integer del(int roleId, int rightId) {
        System.out.println("删除角色的权限 角色id：" + roleId + "权限id：" + rightId);
        return service.del(roleId, rightId);
    }

    @RespBodyResMapping("fenpei")
    public Role fenpei(@RequestBody List<Integer> ids) {
        Integer roleId = ids.get(0);
        return service.fenpei(roleId, ids);
    }
}
