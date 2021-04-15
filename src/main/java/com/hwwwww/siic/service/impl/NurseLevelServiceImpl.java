package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.NurseLevelMapper;
import com.hwwwww.siic.service.NurseLevelService;
import com.hwwwww.siic.vo.NurseLevel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 */
@Service
public class NurseLevelServiceImpl extends ServiceImpl<NurseLevelMapper, NurseLevel> implements NurseLevelService {
    @Override
    public Map<String, Object> selectCustomerWithPage(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>(2);
        //当前页码
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        //每页数
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        //按照名字搜索
        String levelName = (String) params.get("level_name");
        //分页
        QueryWrapper<NurseLevel> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("level_name", levelName);
        PageHelper.startPage(currentPage, pageSize);
        List<NurseLevel> customers = list(queryWrapper);
        //获取查询到的总数
        PageInfo<NurseLevel> pageInfo = new PageInfo<>(customers);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", customers);
        return result;
    }
}
