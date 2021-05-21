package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.UserService;
import com.hwwwww.siic.utils.TokenUtil;
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
    private TokenUtil tokenUtil;
    @RespBodyResMapping("/query")
    public Map<String, Object> getUsers(@RequestParam Map<String, Object> params) throws Exception {
        return service.selectUserWithPage(params);
    }

    @RespBodyResMapping("get-by-id")
    public Map<String, Object> getUserById(Integer id) throws Exception {
        Map<String, Object> map = new HashMap<>(1);
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

    @RespBodyResMapping("/login")
    public Map<String, Object> login(@RequestParam Map<String, Object> params) throws Exception {
        return service.login(params);
    }

    @RespBodyResMapping("/logout")
    public Map<String, Object> logout(String token) throws Exception {
        return service.logout(token);
    }

    @RespBodyResMapping("/info")
    public Map<String, Object> getInfo(String token) throws Exception {
        return service.getInfo(token);
    }

    @RespBodyResMapping("/alive-status")
    public String check() {
        return "pass";
    }

    @RespBodyResMapping("/refresh-token")
    public Map<String, Object> refreshToken(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>(2);
        String token = (String) params.get("token");
        String username = (String) params.get("username");
        try {
            if (tokenUtil.verify(token)) {
                map.put("token", tokenUtil.sign(username, 1));
                map.put("refresh_token", tokenUtil.sign(username, 2));
                map.put("code", 20000);
            }
        } catch (Exception e) {
            map.put("message", "Please login again!");
            map.put("code", 50020);
        }
        return map;
    }
}
