package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwwwww.siic.vo.Food;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {
}