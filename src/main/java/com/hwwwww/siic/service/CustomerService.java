package com.hwwwww.siic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.Customer;
import com.hwwwww.siic.vo.Selector;

import java.util.List;
import java.util.Map;

public interface CustomerService extends IService<Customer> {

    Map<String, Object> selectCustomerWithPage(Map<String, Object> params);

    Map<String, Object> selectCustomerToNurseRecord(Map<String, Object> params);

    List<Map<String, Object>> selectCustomerBedInfo();

    List<String> selectCustomerNames();

    boolean insert(Customer entity);

    boolean update(Customer entity);

    boolean delete(Integer id);

    boolean updateTransferBed(Map<String, Object> params);

    String createRecordId();

    List<Selector> selectCustomerSelector();

    Map<String, Object> selectCustomerWithBedId(Integer bedId);
}
