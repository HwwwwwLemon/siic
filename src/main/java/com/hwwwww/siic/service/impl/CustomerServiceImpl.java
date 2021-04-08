package com.hwwwww.siic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.CustomerMapper;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.vo.Customer;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public Map<String, Object> getCustomerWithPage(Map<String, Object> params) {

        Map<String, Object> result = new HashMap<>(2);
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        String name = (String) params.get("name");
        PageHelper.startPage(currentPage, pageSize);

        List<Customer> customers = list(new QueryWrapper<Customer>().likeRight("customer_name", name));
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
        result.put("list", customers);
        result.put("totalCount", pageInfo.getTotal());
        result.put("code", 200);
        return result;
    }


    @Override
    public boolean insert(Customer entity) {

        return this.save(entity);
    }

    @Override
    public boolean update(Customer entity) {
        return this.updateById(entity);
    }
}
