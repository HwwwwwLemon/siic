package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.RetreatMapper;
import com.hwwwww.siic.service.RetreatService;
import com.hwwwww.siic.vo.Retreat;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RetreatServiceImpl extends ServiceImpl<RetreatMapper, Retreat> implements RetreatService {
    @Override
    public Map<String, Object> selectRetreatWithPage(Map<String, Object> params) throws Exception {
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
        List<Map<String, Object>> outGoingList = baseMapper.selectRetreatByCustomerName(queryWrapper);
        //获取查询到的总数
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(outGoingList);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", outGoingList);
        return result;
    }

    @Override
    public Retreat getRetreatById(Integer id) throws Exception {
        return this.getById(id);
    }

    @Override
    public boolean updateAudit(List<Retreat> retreatList) {
        return this.updateBatchById(retreatList);
    }

    @Override
    public boolean insert(Retreat entity) throws Exception {
        return this.save(entity);
    }

    @Override
    public boolean update(Retreat entity) throws Exception {
        return this.updateById(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return this.removeById(id);
    }
}
