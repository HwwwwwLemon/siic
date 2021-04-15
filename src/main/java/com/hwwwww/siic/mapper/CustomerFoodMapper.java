package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hwwwww.siic.vo.CustomerFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerFoodMapper extends BaseMapper<CustomerFood> {
    @Select("select c.customer_name,c.customer_age,c.customer_sex,cf.*,f.supply_type " +
            "from customer c,customer_food cf,food f ${ew.customSqlSegment} " +
            "AND f.id in (cf.foodid) AND c.id = cf.customerid " +
            "AND cf.is_deleted = 1 AND c.is_deleted = 1" +
            " AND f.is_deleted = 1")
    List<Map<String, Object>> selectCustomerFoodbyNameId(@Param(Constants.WRAPPER) Wrapper<Map<String, Object>> wrapper);
}