package com.hwwwww.siic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.UserService;
import com.hwwwww.siic.utils.RSAUtil;
import com.hwwwww.siic.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/9 11:45
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private RSAUtil rsa;

    @RespBodyResMapping("/query")
    public String getUsers(@RequestParam Map<String, Object> params) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(service.selectUserWithPage(params));
    }

    @RespBodyResMapping("get-by-id")
    public Map<String, Object> getUserById(Integer id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user", service.getUserById(id));
        return map;
    }

    @RespBodyResMapping("/add")
    public boolean addUser(User user) throws Exception {
        return service.insert(user);
    }

    @RespBodyResMapping("/update")
    public boolean updateUser(User user) throws Exception {
        return service.update(user);
    }

    @RespBodyResMapping("/del")
    public boolean deleteUser(Integer id) {
        return service.delete(id);
    }

    @RespBodyResMapping("/modify-password")
    public boolean modifyPassword(@RequestParam Map<String, Object> params) throws Exception {
        return service.modifyPassword(params);
    }
}
