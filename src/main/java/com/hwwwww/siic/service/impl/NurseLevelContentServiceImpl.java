package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.NurseLevelContentMapper;
import com.hwwwww.siic.service.NurseLevelContentService;
import com.hwwwww.siic.vo.NurseLevelContent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NurseLevelContentServiceImpl extends ServiceImpl<NurseLevelContentMapper, NurseLevelContent> implements NurseLevelContentService {

    @Override
    public Map<String, Object> selectNurseLevelContentByNurseLevelId(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>(2);
        //当前页码
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        //每页数
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //按照名字搜索
        int id = Integer.parseInt((String) params.get("id"));
        //分页
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String, Object>> nurseLevelContentList = baseMapper.selectNurseLevelContentByNurseLevelId(id);
        //获取查询到的总数
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(nurseLevelContentList);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", nurseLevelContentList);
        return result;
    }

    @Override
    public boolean insert(NurseLevelContent entity) {
        System.out.println(entity);
        return this.save(entity);
    }

    @Override
    public boolean update(NurseLevelContent entity) {
        return this.updateById(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return this.removeById(id);
    }
}
