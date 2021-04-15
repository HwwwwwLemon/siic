package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.CustomerFoodMapper;
import com.hwwwww.siic.service.CustomerFoodService;
import com.hwwwww.siic.vo.CustomerFood;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerFoodServiceImpl extends ServiceImpl<CustomerFoodMapper, CustomerFood> implements CustomerFoodService {
    @Override
    public Map<String, Object> selectCustomerFoodWithPage(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>(2);
        //当前页码
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        //每页数
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //按照名字搜索
        String name = (String) params.get("name");
        String date = (String) params.get("date");
        String type = (String) params.get("type");
        //分页
        QueryWrapper<Map<String, Object>> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("c.customer_name", name);
        queryWrapper.likeRight("cf.fooddate", date);
        queryWrapper.likeRight("f.supply_type", type);
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String, Object>> customers = baseMapper.selectCustomerFoodbyNameId(queryWrapper);
        //获取查询到的总数
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(customers);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", customers);
        return result;
    }

    @Override
    public Map<String, Object> selectCustomerFoodById(Integer id) {
        Map<String, Object> result = new HashMap<>(1);
        QueryWrapper<Map<String, Object>> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cf.id", id);
        List<Map<String, Object>> customers = baseMapper.selectCustomerFoodbyNameId(queryWrapper);
        if (customers.size() > 0) {
            result.put("customerFood", customers.get(0));
        }

        return result;
    }

    @Override
    public boolean insert(List<CustomerFood> entity) {
        if (entity.size() != 0) {
            return this.saveBatch(entity);
        }
        return false;
    }

    @Override
    public boolean update(List<CustomerFood> entity) {
        if (entity.size() != 0) {
            return this.updateById(entity.get(0));
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return this.removeById(id);
    }
}
