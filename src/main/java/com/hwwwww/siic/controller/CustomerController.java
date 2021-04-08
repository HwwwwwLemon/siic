package com.hwwwww.siic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/8 9:09
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @RequestMapping("/query")
    @ResponseBody
    public String getAllCustomers(@RequestParam Map<String, Object> params) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(service.getCustomerWithPage(params));

    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addCustomer(Customer customer) {
        return service.insert(customer);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updateCustomer(Customer customer) {
        return service.update(customer);
    }

    @RequestMapping("/del")
    @ResponseBody
    public boolean deleteCustomer(Integer id) {
        return service.removeById(id);
    }
    @RequestMapping("/get-by-id")
    @ResponseBody
    public String getCustomerById(Integer id) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>(1);
        map.put("customer", service.getById(id));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);

    }
}
