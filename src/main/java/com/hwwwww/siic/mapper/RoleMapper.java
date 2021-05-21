package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwwwww.siic.vo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    public List<Role> getroles();
}