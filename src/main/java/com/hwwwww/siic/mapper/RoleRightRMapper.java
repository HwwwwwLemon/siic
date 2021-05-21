package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwwwww.siic.vo.RoleRightR;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface RoleRightRMapper extends BaseMapper<RoleRightR> {

    public Integer del(Map<String, Integer> map);

    Integer delbyroleid(Integer roleid);
}