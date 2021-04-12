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
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        //获取查询到的总数
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(customers);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", customers);
        return result;
    }

    @Override
    public List<Map<String, Object>> selectCustomerBedInfo() {
        return baseMapper.selectCustomerBedInfo();
    }

    @Override
    public boolean insert(Customer entity) {
        return this.save(entity) && bedService.changeBedStatus(entity.getBedId(), 2);
    }

    @Override
    public boolean update(Customer entity) {
        Integer lastBedId = this.getById(entity.getId()).getBedId();
        boolean result = this.updateById(entity);
        if (!lastBedId.equals(entity.getBedId())) {
            log.debug("改动床位!");
            result = result && bedService.changeBedStatus(lastBedId, 1);
            result = result && bedService.changeBedStatus(entity.getBedId(), 2);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        Customer entity = this.getById(id);
        return removeById(entity.getId()) && bedService.changeBedStatus(entity.getBedId(), 1);
    }

    @Override
    public boolean updateTransferBed(Map<String, Object> params) {
        Integer id1 = Integer.parseInt((String) params.get("v1"));
        Integer id2 = Integer.parseInt((String) params.get("v2"));
        if (id1.equals(id2)) {
            return false;
        }
        Customer customer1 = this.getById(id1);
        Customer customer2 = this.getById(id2);
        Customer customerTransfer = new Customer();
        //中间
        customerTransfer.setBedId(customer1.getBedId());
        customerTransfer.setBuildingId(customer1.getBuildingId());
        customerTransfer.setRoomNumber(customer1.getRoomNumber());
        //交换1
        customer1.setBedId(customer2.getBedId());
        customer1.setBuildingId(customer2.getBuildingId());
        customer1.setRoomNumber(customer2.getRoomNumber());
        //交换2
        customer2.setBedId(customerTransfer.getBedId());
        customer2.setBuildingId(customerTransfer.getBuildingId());
        customer2.setRoomNumber(customerTransfer.getRoomNumber());
        boolean result = updateById(customer1);
        result = result && updateById(customer2);
        return result;
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
