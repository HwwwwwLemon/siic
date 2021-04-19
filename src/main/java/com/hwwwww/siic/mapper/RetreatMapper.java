package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hwwwww.siic.vo.Retreat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RetreatMapper extends BaseMapper<Retreat> {
    @Select("select c.id cid, customer_name, c.customer_age, customer_sex, checkin_date, record_id, r.* from customer c,retreat r " +
            "${ew.customSqlSegment} and c.is_deleted = 1 and r.is_deleted = 1 and c.id = r.customerid")
    List<Map<String, Object>> selectRetreatByCustomerName(@Param(Constants.WRAPPER) Wrapper<Map<String, Object>> userWrapper);
}