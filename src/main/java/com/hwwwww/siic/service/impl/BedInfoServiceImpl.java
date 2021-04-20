package com.hwwwww.siic.service.impl;

import com.hwwwww.siic.service.BedInfoService;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.service.NurseLevelContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/20 14:20
 */
@Service
public class BedInfoServiceImpl implements BedInfoService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private NurseLevelContentService nurseLevelContentService;

    @Override
    public Map<String, Object> selectInfo(Integer id) {
        //获取基本信息
        Map<String, Object> customer = customerService.selectCustomerWithBedId(id);
        //获取护理信息
        List<Map<String, Object>> nurseLevelContentList = nurseLevelContentService.selectNurseLevelContentByNurseLevelId((Integer) customer.get("nurseLevel"));
        Map<String, Object> map = new HashMap<>(2);
        map.put("customer", customer);
        map.put("nurseContent", nurseLevelContentList);
        return map;
    }
}
