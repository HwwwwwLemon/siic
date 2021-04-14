package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.FoodTypeService;
import com.hwwwww.siic.vo.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/14 9:03
 */
@RestController
@RequestMapping("/food-type")
public class FoodTypeController {
    @Autowired
    private FoodTypeService service;

    @RespBodyResMapping("/get-food-type")
    public List<Selector> getFoodType() {
        return service.selectFoodTypeByType(1);
    }

    @RespBodyResMapping("/get-food-label")
    public List<Selector> getFoodLabel() {
        return service.selectFoodTypeByType(2);
    }
}
