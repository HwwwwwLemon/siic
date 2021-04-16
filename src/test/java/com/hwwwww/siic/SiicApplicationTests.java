package com.hwwwww.siic;

import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.service.FoodService;
import com.hwwwww.siic.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SiicApplicationTests {
    @Autowired
    private BedService bedService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private RSAUtil rsa;

    @Test
    void contextLoads() throws Exception {
//        Map<String, Object> map = new HashMap<>();
//        map.put("date", "");
//        map.put("type", "");
//        System.out.println(foodService.selectFoodQuantity(map));
        System.out.println(rsa.publicKeyDecrypt("LaebmqWapEGLZIDYZkViFdM4AdC04Chbi3AJk3sTkDv51hzS9qswN8krcyWAe0l/gOQjnXNcped2dLD7JJJaoYZtfrAs7htP3gBc8dlmRO9rKFC2xataLzYW14AtRbdbVR4Cu4EImAeryqvU4Fh4Gqu4b8HgTyUZpMMsxKn65QlKBT8yzJDoulgsbTtQzoAxk0DaRs1xrYIgU3JdhqfgZ1YIGzKvmh9jSnAMr/L0O+DcIOoaSIjZVbz5n/eY3F5GTJZpS0LxcxdGP2fPIcs08rky7j2BUAEgNNig76aWVK6duBv2Q0UpIsWW4feMqeAhWLAnoMNRKTa9BWYrnB3J8g=="));
//        System.out.println(RSAUtil.genKeyPair());

    }

}
