package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.NurseContentMapper;
import com.hwwwww.siic.service.NurseContentService;
import com.hwwwww.siic.vo.NurseContent;
import com.hwwwww.siic.vo.Selector;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class NurseContentServiceImpl extends ServiceImpl<NurseContentMapper, NurseContent> implements NurseContentService {
    @Override
    public Map<String, Object> selectNurseContentWithPage(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>(2);
        //当前页码
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        //每页数
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //按照名字搜索
        String name = (String) params.get("name");

        QueryWrapper<NurseContent> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name", name);
        //分页
        PageHelper.startPage(currentPage, pageSize);
        List<NurseContent> nurseContentList = list();
        //获取查询到的总数
        PageInfo<NurseContent> pageInfo = new PageInfo<>(nurseContentList);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", nurseContentList);
        return result;
    }

    @Override
    public boolean insert(NurseContent entity) {
        return this.save(entity);
    }

    @Override
    public boolean update(NurseContent entity) {
        return this.updateById(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return this.removeById(id);
    }

    @Override
    public List<Selector> selectNurseContentSelector() {
        List<NurseContent> nurseContentList = this.list();
        List<Selector> selector = new LinkedList<>();
        for (NurseContent nurseContent : nurseContentList) {
            selector.add(new Selector(nurseContent.getName(), nurseContent.getId()));
        }
        return selector;
    }
}
