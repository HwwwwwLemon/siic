package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.FoodMapper;
import com.hwwwww.siic.service.FoodService;
import com.hwwwww.siic.vo.Food;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Override
    public Map<String, List<Food>> selectFoodByDay(Integer day) {

        Map<String, List<Food>> map = new HashMap<>();
        List<Food> breakFast = this.list(new QueryWrapper<Food>().eq("supply_date", day).eq("supply_type", 1));
        List<Food> lunch = this.list(new QueryWrapper<Food>().eq("supply_date", day).eq("supply_type", 2));
        List<Food> dinner = this.list(new QueryWrapper<Food>().eq("supply_date", day).eq("supply_type", 3));
        map.put("breakFast", breakFast);
        map.put("lunch", lunch);
        map.put("dinner", dinner);
        return map;
    }

}
