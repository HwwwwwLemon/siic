package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwwwww.siic.vo.Customer;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespace(flushInterval = 30000)
public interface CustomerMapper extends BaseMapper<Customer> {
}