package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hwwwww.siic.vo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    @Select("select c.*,b.name bed_id_name from customer c,bed b ${ew.customSqlSegment} AND c.bed_id = b.id AND c.is_deleted=1")
    @ResultMap("CustomerMap")
    List<Map<String, Object>> selectCustomerbyName(@Param(Constants.WRAPPER) Wrapper<Map<String, Object>> userWrapper);

    @Select("select id,customer_name, bed_id, building_id, room_number from customer Where  is_deleted=1")
    @ResultMap("BedTransfer")
    List<Map<String, Object>> selectCustomerBedInfo();

    @Select("select id,customer_name from customer Where  is_deleted=1")
    List<Customer> selectCustomerSelector();

    @Select("select c.id, customer_name, customer_sex, customer_age,attention,food_attention, n.level_name,nurse_level, bed_status " +
            "from customer c, " +
            "     bed b, " +
            "     nurse_level n " +
            "where c.nurse_level = n.id and bed_id = b.id and bed_id = #{bedId} ")
    Map<String, Object> selectCustomerWithBedId(Integer bedId);
}