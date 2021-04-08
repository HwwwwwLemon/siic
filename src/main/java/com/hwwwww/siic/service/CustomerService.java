package com.hwwwww.siic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService extends IService<Customer> {

    Map<String, Object> getCustomerWithPage(Map<String, Object> params);

    boolean insert(Customer entity);
    boolean update(Customer entity);
}
