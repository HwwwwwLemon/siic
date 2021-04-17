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
        System.out.println(rsa.privateKeyDecrypt("MkSekjMEX7+piG+dxTgqSfYISoitcdtZrgp7Eldi+hdQrEERtONkISze8sloqCVkGW81R5YuIISAFEQg5WOTVN8UoDRhZzyAMhgXwpXf9TtKWdwSeQyfxBXc2pT0zWpwom62WZH3SFi4mmiXJQ+eYX/6r0tkONncKStjwfNTAGI= MkSekjMEX7+piG+dxTgqSfYISoitcdtZrgp7Eldi+hdQrEERtONkISze8sloqCVkGW81R5YuIISAFEQg5WOTVN8UoDRhZzyAMhgXwpXf9TtKWdwSeQyfxBXc2pT0zWpwom62WZH3SFi4mmiXJQ+eYX/6r0tkONncKStjwfNTAGI="));
//        System.out.println(RSAUtil.genKeyPair());

    }

}
