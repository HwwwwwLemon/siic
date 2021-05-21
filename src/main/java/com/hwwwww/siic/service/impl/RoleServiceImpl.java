package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.RoleMapper;
import com.hwwwww.siic.service.RoleService;
import com.hwwwww.siic.vo.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<Role> getroles() {
        return baseMapper.getroles();
    }
}
