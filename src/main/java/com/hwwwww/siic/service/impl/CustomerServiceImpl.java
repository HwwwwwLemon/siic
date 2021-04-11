package com.hwwwww.siic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.CustomerMapper;
import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.utils.GeneralUtil;
import com.hwwwww.siic.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private BedService bedService;

    @Override
    public Map<String, Object> selectCustomerWithPage(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>(2);
        //当前页码
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        //每页数
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //按照名字搜索
        String name = (String) params.get("name");
        //分页
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String, Object>> customers = baseMapper.selectCustomerbyName(new QueryWrapper<Map<String, Object>>().likeRight("customer_name", name));
        System.out.println(customers);
        //获取查询到的总数
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(customers);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", customers);
        return result;
    }


    @Override
    public boolean insert(Customer entity) {
        return this.save(entity) && bedService.changeBedStatus(entity.getBedId(), 2);
    }

    @Override
    public boolean update(Customer entity) {
        Integer lastBedId = this.getById(entity.getId()).getBedId();
        return this.updateById(entity) && bedService.changeBedStatus(lastBedId, 1) && bedService.changeBedStatus(entity.getBedId(), 2);
    }

    @Override
    public boolean delete(Integer id) {
        Customer entity = this.getById(id);
        return removeById(entity.getId()) && bedService.changeBedStatus(entity.getBedId(), 1);
    }

    @Override
    public String createRecordId() {
        StringBuilder sb = new StringBuilder("SIIC");
        Date now = new Date();
        String sdf = new SimpleDateFormat("yyyyMMddHHmmss").format(now);
        int count = baseMapper.selectCount(new QueryWrapper<Customer>().likeRight("record_id", sdf)) + 1;
        sb.append(sdf).append(GeneralUtil.addZero(Integer.toString(count), 4));
        System.out.println(sb);
        return sb.toString();
    }
}
