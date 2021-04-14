package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hwwwww.siic.vo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 */
@Mapper
@CacheNamespace(flushInterval = 30000)
public interface CustomerMapper extends BaseMapper<Customer> {
    @Select("select c.*,b.name bed_id_name from customer c,bed b ${ew.customSqlSegment} AND c.bed_id = b.id")
    @ResultMap("CustomerMap")
    List<Map<String, Object>> selectCustomerbyName(@Param(Constants.WRAPPER) Wrapper<Map<String, Object>> userWrapper);

    @Select("select id,customer_name, bed_id, building_id, room_number from customer")
    @ResultMap("BedTransfer")
    List<Map<String, Object>> selectCustomerBedInfo();

    @Select("select id,customer_name from customer")
    List<Customer> selectCustomerSelector();
}