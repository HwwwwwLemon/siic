package com.hwwwww.siic;

import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class SiicApplicationTests {
    @Autowired
    private BedService bedService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private FoodService foodService;

    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("date", "");
        map.put("type", "");
        System.out.println(foodService.selectFoodQuantity(map));
    }

}
