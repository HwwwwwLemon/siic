package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.FoodType;
import com.hwwwww.siic.vo.Selector;

import java.util.List;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/14 8:59
 */
public interface FoodTypeService extends IService<FoodType> {
    List<Selector> selectFoodTypeByType(Integer type);
}