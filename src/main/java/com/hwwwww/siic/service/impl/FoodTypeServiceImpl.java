package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.FoodTypeMapper;
import com.hwwwww.siic.service.FoodTypeService;
import com.hwwwww.siic.vo.FoodType;
import com.hwwwww.siic.vo.Selector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/14 9:00
 */
@Service
public class FoodTypeServiceImpl extends ServiceImpl<FoodTypeMapper, FoodType> implements FoodTypeService {
    @Override
    public List<Selector> selectFoodTypeByType(Integer type) {
        List<Selector> selector = new ArrayList<>();
        QueryWrapper<FoodType> wrapper = new QueryWrapper<>();
        if (type == 1) {
            wrapper.eq("type", 1);
        } else if (type == 2) {
            wrapper.eq("type", 2);
        } else {
            return selector;
        }
        List<FoodType> typeList = list(wrapper);
        for (FoodType ft : typeList) {
            selector.add(new Selector(ft.getLabel(), ft.getLabel()));
        }
        return selector;
    }
}
