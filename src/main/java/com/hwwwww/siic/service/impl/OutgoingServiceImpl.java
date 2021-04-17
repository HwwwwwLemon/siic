package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.OutgoingMapper;
import com.hwwwww.siic.service.OutgoingService;
import com.hwwwww.siic.vo.OutGoing;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OutgoingServiceImpl extends ServiceImpl<OutgoingMapper, OutGoing> implements OutgoingService {
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
}