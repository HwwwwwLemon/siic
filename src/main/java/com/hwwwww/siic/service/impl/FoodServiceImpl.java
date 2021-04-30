package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.FoodMapper;
import com.hwwwww.siic.service.FoodService;
import com.hwwwww.siic.vo.Food;
import com.hwwwww.siic.vo.Selector;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    private static final Integer BREAKFAST = 1;
    private static final Integer LUNCH = 2;
    private static final Integer DINNER = 3;
    private static final Integer ALL = 4;

    @Override
    public Map<String, List<Food>> selectFoodByDay(Integer day, Integer key) {
        Map<String, List<Food>> map = new HashMap<>();
        if (key.equals(BREAKFAST) || key.equals(ALL)) {
            List<Food> breakFast = this.list(new QueryWrapper<Food>().eq("supply_date", day).eq("supply_type", 1));
            map.put("breakFast", breakFast);
        }
        if (key.equals(LUNCH) || key.equals(ALL)) {
            List<Food> lunch = this.list(new QueryWrapper<Food>().eq("supply_date", day).eq("supply_type", 2));
            map.put("lunch", lunch);
        }
        if (key.equals(DINNER) || key.equals(ALL)) {
            List<Food> dinner = this.list(new QueryWrapper<Food>().eq("supply_date", day).eq("supply_type", 3));
            map.put("dinner", dinner);
        }
        return map;
    }

    @Override
    public Map<String, Object> selectFoodQuantity(Map<String, Object> params) {
        String date = (String) params.get("date");
        String type = (String) params.get("type");
        //分页
        QueryWrapper<Map<String, Object>> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.likeRight("cf.fooddate", date);
        queryWrapper1.likeRight("f.supply_type", type);
        QueryWrapper<String> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.likeRight("cf.fooddate", date);
        queryWrapper2.likeRight("f.supply_type", type);

        Map<String, Object> result = new HashMap<>();
        //标签
        List<String> tags = baseMapper.selectFoodType(queryWrapper2);
        //当日膳食数量
        List<Map<String, Object>> foods = new LinkedList<>(baseMapper.selectFoodQuantity(queryWrapper1));

        //循环按照foodtype分类
        for (String tagName : tags) {
            //临时List
            List<Map<String, Object>> tempList = new LinkedList<>();
            int count = 0;
            for (Iterator<Map<String, Object>> iter = foods.iterator(); iter.hasNext(); ) {
                Map<String, Object> tempMap = iter.next();
                if (tempMap.get("foodtype").equals(tagName)) {
                    tempList.add(tempMap);
                    iter.remove();
                }
                count++;
            }
            result.put(tagName, tempList);
        }
        result.put("tags", tags);
        return result;
    }

    @Override
    public List<Food> getFoodByIdList(List<Integer> idList) {
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        return this.list(wrapper.in("id", idList));
    }

    @Override
    public boolean insert(Food entity) {
        return this.save(entity);
    }

    @Override
    public boolean update(Food entity) {
        return this.updateById(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return this.removeById(id);
    }

    @Override
    public List<Selector> getFoodBySupplyDate(Integer date) {
        String[] weeks = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"};
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        List<Food> foods = list(wrapper.eq("supply_date", date));
        List<Selector> selector = new ArrayList<>();
        for (Food f : foods) {
            selector.add(new Selector(weeks[f.getSupplyDate() - 1], weeks[f.getSupplyDate() - 1]));
        }
        return selector;
    }

    @Override
    public List<Selector> getFoodBySupplyType(Integer type) {
        String[] weeks = new String[]{"早餐", "午餐", "晚餐"};
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        List<Food> foods = list(wrapper.eq("supply_type", type));
        List<Selector> selector = new ArrayList<>();
        for (Food f : foods) {
            selector.add(new Selector(weeks[f.getSupplyType() - 1], weeks[f.getSupplyType() - 1]));
        }
        return selector;
    }

}
