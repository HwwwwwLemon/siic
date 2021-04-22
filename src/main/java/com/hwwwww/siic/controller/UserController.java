package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.UserService;
import com.hwwwww.siic.utils.MyLogger;
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

    @RespBodyResMapping("/query")
    public Map<String, Object> getUsers(@RequestParam Map<String, Object> params) throws Exception {

        return service.selectUserWithPage(params);
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

    @RespBodyResMapping("/refresh-token")
    public Map<String, Object> refreshToken(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>(2);
        String token = (String) params.get("token");
        String username = (String) params.get("username");
        MyLogger.info("token:{},username:{}",token,username);
        int code = TokenUtil.isRefreshToken(token);
        if (code == 1) {
            map.put("token", TokenUtil.sign(username));
            map.put("code", 20000);
        } else if (code == 0) {
            map.put("code", 50001);
        }
        return map;
    }
}
