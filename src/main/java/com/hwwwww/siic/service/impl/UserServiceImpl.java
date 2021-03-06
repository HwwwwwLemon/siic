package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.UserMapper;
import com.hwwwww.siic.service.UserService;
import com.hwwwww.siic.utils.RSAUtil;
import com.hwwwww.siic.utils.TokenUtil;
import com.hwwwww.siic.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RSAUtil rsa;
    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public Map<String, Object> selectUserWithPage(Map<String, Object> params) throws Exception {
        Map<String, Object> result = new HashMap<>(2);
        //当前页码
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        //每页数
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //按照名字搜索
        String username = (String) params.get("username");
        String userCode = (String) params.get("user_code");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("username", username).or().likeRight("user_code", userCode);

        //分页
        PageHelper.startPage(currentPage, pageSize);
        List<User> userList = list(queryWrapper);
        //获取查询到的总数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        result.put("totalCount", pageInfo.getTotal());
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            u.setPassword(rsa.privateKeyEncrypt(u.getPassword()));
            userList.set(i, u);
        }

        result.put("list", userList);
        return result;
    }

    @Override
    public User getUserById(Integer id) throws Exception {
        User u = this.getById(id);
        u.setPassword(rsa.privateKeyEncrypt(u.getPassword()));
        return u;
    }

    @Override
    public boolean insert(User entity) throws Exception {
        entity.setPassword(rsa.privateKeyDecrypt(entity.getPassword()));
        return this.save(entity);
    }

    @Override
    public boolean update(User entity) throws Exception {
        entity.setPassword(rsa.privateKeyDecrypt(entity.getPassword()));
        return this.updateById(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return this.removeById(id);
    }

    @Override
    public boolean modifyPassword(Map<String, Object> params) throws Exception {
        int id = Integer.parseInt((String) params.get("id"));
        String originalPassword = (String) params.get("originalPassword");
        User user = this.getById(id);
        originalPassword = rsa.privateKeyDecrypt(originalPassword);
        if (originalPassword.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> login(Map<String, Object> params) throws Exception {
        Map<String, Object> map = new HashMap<>(4);
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        password = rsa.privateKeyDecrypt(password);
        User user = this.getOne(new QueryWrapper<User>().eq("username", username));
        if (user != null) {
            if (user.getPassword().equals(password)) {
                map.put("token", tokenUtil.sign(username, 1));
                map.put("refresh_token", tokenUtil.sign(username, 2));
                map.put("id", user.getId());
                map.put("name", user.getNickname());
                map.put("username", user.getUsername());
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> logout(String token) {
        Map<String, Object> map = new HashMap<>(4);
        String username = tokenUtil.getInfo(token);
        if (username != null) {
            User user = this.getOne(new QueryWrapper<User>().eq("username", username));
            if (user != null) {
                map.put("token", tokenUtil.sign(username, 1));
                map.put("id", user.getId());
                map.put("name", user.getNickname());

            }
        }
        return map;
    }

    @Override
    public Map<String, Object> getInfo(String token) {
        Map<String, Object> map = new HashMap<>(4);
        String username = tokenUtil.getInfo(token);
        if (username != null) {
            User user = this.getOne(new QueryWrapper<User>().eq("username", username));
            if (user != null) {
                map.put("token", tokenUtil.sign(username, 1));
                map.put("id", user.getId());
                map.put("name", user.getNickname());
                map.put("username", user.getUsername());
            }
        }

        return map;
    }
}
