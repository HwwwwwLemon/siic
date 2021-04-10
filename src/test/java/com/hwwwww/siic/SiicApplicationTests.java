package com.hwwwww.siic;

import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SiicApplicationTests {
    @Autowired
    private BedService bedService;
    @Autowired
    private CustomerService customerService;
    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("currentPage", "1");
        map.put("pageSize", "10");
        map.put("name", "");
        System.out.println(customerService.selectCustomerWithPage(map));
    }

}
