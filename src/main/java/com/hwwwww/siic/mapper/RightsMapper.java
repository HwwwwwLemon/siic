package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwwwww.siic.vo.Rights;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RightsMapper extends BaseMapper<Rights> {
    public List<Rights> getright1(Integer roleid);

    public List<Rights> getallright1();
}