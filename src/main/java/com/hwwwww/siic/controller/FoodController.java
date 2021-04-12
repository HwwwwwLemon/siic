package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.FoodService;
import com.hwwwww.siic.vo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/12 21:08
 */
@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @RespBodyResMapping("/get-with-date")
    public Map<String, List<Food>> getBySupplyDate(Integer supplyDate) {
        return foodService.selectFoodByDay(supplyDate);
    }
}
