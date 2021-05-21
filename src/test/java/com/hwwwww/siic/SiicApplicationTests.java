package com.hwwwww.siic;

import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.service.FoodService;
import com.hwwwww.siic.service.NurseRecordService;
import com.hwwwww.siic.utils.GeneralUtil;
import com.hwwwww.siic.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    private NurseRecordService nurseRecordService;
    @Autowired
    private RSAUtil rsa;

    @Test
    void contextLoads() throws Exception {
        List<String> res = GeneralUtil.regexResult("([a-z-_1-9]+)", "rights/getallrights");
        for (String i :res)
        System.out.println(i);
    }

}
