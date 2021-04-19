package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.vo.Customer;
import com.hwwwww.siic.vo.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RespBodyResMapping("/query")
    public Map<String, Object> getAllCustomers(@RequestParam Map<String, Object> params) throws JsonProcessingException {
        return service.selectCustomerWithPage(params);

    }

    @RespBodyResMapping("/get-customer-selector")
    public List<Selector> getCustomerSelector() {
        return service.selectCustomerSelector();
    }

    @RespBodyResMapping("/get-bed-info")
    public List<Map<String, Object>> getBedInfo() {
        return service.selectCustomerBedInfo();
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

    @RespBodyResMapping("transfer-bed")
    public boolean transferBed(@RequestParam Map<String, Object> params) {
        return service.updateTransferBed(params);
    }

    @RespBodyResMapping("/get-by-id")
    public Map<String, Object> getCustomerById(Integer id) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>(1);
        map.put("customer", service.getById(id));

        return map;
    }

    @RespBodyResMapping("/get-record-id")
    public String getRecordId() {
        return service.createRecordId();
    }
}
