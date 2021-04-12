package com.hwwwww.siic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.Food;

import java.util.List;
import java.util.Map;

public interface FoodService extends IService<Food> {

    /**
     * 根据提供的日期星期一至星期天查询当天供应的食物
     *
     * @param day 星期几
     * @return 按照早中晚分类好
     */
    Map<String, List<Food>> selectFoodByDay(Integer day);
}
