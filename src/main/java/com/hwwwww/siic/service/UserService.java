package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.User;

import java.util.Map;

public interface UserService extends IService<User> {

    Map<String, Object> selectUserWithPage(Map<String, Object> params) throws Exception;

    User getUserById(Integer id) throws Exception;

    boolean insert(User entity) throws Exception;

    boolean update(User entity) throws Exception;

    boolean delete(Integer id);

    boolean modifyPassword(Map<String, Object> params) throws Exception;

    Map<String, Object> login(Map<String, Object> params) throws Exception;

    Map<String, Object> logout(String token);

    Map<String, Object> getInfo(String token);
}
