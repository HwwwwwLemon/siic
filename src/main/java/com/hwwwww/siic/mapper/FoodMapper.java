package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hwwwww.siic.vo.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {
    @Select("select count(foodname) quantity, f.foodtype, foodname, f.supply_type " +
            "from customer_food cf,food f " +
            "${ew.customSqlSegment} AND cf.foodid = f.id AND cf.is_deleted = 1 AND f.is_deleted = 1 " +
            "group by foodname")
    List<Map<String, Object>> selectFoodQuantity(@Param(Constants.WRAPPER) Wrapper<Map<String, Object>> userWrapper);

    @Select("select distinct f.foodtype from customer_food cf,food f  ${ew.customSqlSegment} AND cf.foodid = f.id AND cf.is_deleted = 1 AND f.is_deleted = 1 ")
    List<String> selectFoodType(@Param(Constants.WRAPPER) Wrapper<String> userWrapper);
}