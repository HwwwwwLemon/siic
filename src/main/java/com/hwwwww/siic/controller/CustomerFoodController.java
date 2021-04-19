package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.CustomerFoodService;
import com.hwwwww.siic.vo.CustomerFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/14 9:41
 */
@RestController
@RequestMapping("/customer-food")
public class CustomerFoodController {
    @Autowired
    private CustomerFoodService service;

    @RespBodyResMapping("/query")
    public Map<String, Object> getAllCustomerFoods(@RequestParam Map<String, Object> params) throws JsonProcessingException {
        return service.selectCustomerFoodWithPage(params);

    }

    @RespBodyResMapping("/add")
    public boolean addCustomer(@RequestBody List<CustomerFood>  customerFoods) {
        return service.insert(customerFoods);
    }

    @RespBodyResMapping("/update")
    public boolean updateCustomer(@RequestBody List<CustomerFood>  customerFoods) {
        return service.update(customerFoods);
    }

    @RespBodyResMapping("/del")
    public boolean deleteCustomer(Integer id) {
        return service.delete(id);
    }

    @RespBodyResMapping("get-by-id")
    public Map<String, Object> getCustomerFoodById(Integer id) throws JsonProcessingException {
        return service.selectCustomerFoodById(id);
    }

}
