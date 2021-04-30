package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.OutgoingMapper;
import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.service.OutgoingService;
import com.hwwwww.siic.vo.Customer;
import com.hwwwww.siic.vo.OutGoing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OutgoingServiceImpl extends ServiceImpl<OutgoingMapper, OutGoing> implements OutgoingService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BedService bedService;

    @Override
    public Map<String, Object> selectOutGoingWithPage(Map<String, Object> params) throws Exception {
        Map<String, Object> result = new HashMap<>(2);
        //当前页码
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        //每页数
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //按照名字搜索
        String username = (String) params.get("username");

        QueryWrapper<Map<String, Object>> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("c.customer_name", username);

        //分页
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String, Object>> outGoingList = baseMapper.selectOutGoingByCustomerName(queryWrapper);
        //获取查询到的总数
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(outGoingList);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", outGoingList);
        return result;
    }

    @Override
    public boolean updateAudit(List<OutGoing> outGoingList) {
        List<OutGoing> passList = new LinkedList<>();
        for (OutGoing outGoing : outGoingList) {
            Customer customer = customerService.getById(outGoing.getCustomerid());
            if("审批通过".equals(outGoing.getAuditStatus())){
                 bedService.changeBedStatus(customer.getBedId(), 3);
            }
            long diff = System.currentTimeMillis() - outGoing.getAuditTime().getTime();
            if (diff < 60 * 1000 ) {

                passList.add(outGoing);
            }
        }
        return this.updateBatchById(passList);
    }

    @Override
    public OutGoing getOutGoingById(Integer id) throws Exception {
        return this.getById(id);
    }

    @Override
    public boolean insert(OutGoing entity) throws Exception {
        return this.save(entity);
    }

    @Override
    public boolean update(OutGoing entity) throws Exception {
        if (entity.getActualReturnTime() != null) {
            long fromFront = entity.getActualReturnTime().getTime();
            long outGoingTime = entity.getOutgoingTime().getTime();
            long difference = fromFront - outGoingTime;
            if (difference < 0) {
                return false;
            }
            Customer customer = customerService.getById(entity.getCustomerid());
            bedService.changeBedStatus(customer.getBedId(), 2);
        }
        return this.updateById(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return this.removeById(id);
    }
}