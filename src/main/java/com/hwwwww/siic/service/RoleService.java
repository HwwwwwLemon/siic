package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.Role;

import java.util.List;

public interface RoleService extends IService<Role> {

    public List<Role> getroles(Integer id);
    boolean checkRoles(Integer userId,String path);
}
