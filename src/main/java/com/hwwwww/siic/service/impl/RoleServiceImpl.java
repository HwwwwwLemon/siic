package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.RoleMapper;
import com.hwwwww.siic.service.RoleService;
import com.hwwwww.siic.utils.GeneralUtil;
import com.hwwwww.siic.vo.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<Role> getroles(Integer id) {
        return baseMapper.getroles(id);
    }

    @Override
    public boolean checkRoles(Integer userId, String path) {
        List<String> pathList = GeneralUtil.regexResult("([a-z-_1-9]+)", path);
        String rootPath = pathList.get(0);
        String childPath = pathList.get(1);
        //检查rootPath权限
        if (baseMapper.checkRole(userId, "%" + rootPath + "%").size() <= 0) {
            return false;
        }
        return baseMapper.checkRole(userId, "%" + path + "%").size() > 0;
    }
}
