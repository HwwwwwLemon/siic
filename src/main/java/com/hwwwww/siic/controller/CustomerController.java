package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    @RespBodyResMapping("/query")
    public Map<String, Object> getAllCustomers(@RequestParam Map<String, Object> params) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = service.selectCustomerWithPage(params);

        return result;

    }

    @RespBodyResMapping("/add")
    public boolean addCustomer(Customer customer) {
        return service.insert(customer);
    }

    @RespBodyResMapping("/update")
    public boolean updateCustomer(Customer customer) {
        return service.update(customer);
    }

    @RespBodyResMapping("/del")
    public boolean deleteCustomer(Integer id) {
        return service.delete(id);
    }

    @RespBodyResMapping("/get-by-id")
    public String getCustomerById(Integer id) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>(1);
        map.put("customer", service.getById(id));
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(map);

    }
    @RespBodyResMapping("/get-record-id")
    public String getRecordId(){
        return service.createRecordId();
    }
}
