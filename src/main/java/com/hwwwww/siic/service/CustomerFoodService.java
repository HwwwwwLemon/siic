package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.CustomerFood;

import java.util.List;
import java.util.Map;

public interface CustomerFoodService extends IService<CustomerFood> {

    Map<String, Object> selectCustomerFoodWithPage(Map<String, Object> params);


    Map<String, Object> selectCustomerFoodById(Integer id);

    boolean insert(List<CustomerFood> entity);

    boolean update(List<CustomerFood> entity);

    boolean delete(Integer id);

}
