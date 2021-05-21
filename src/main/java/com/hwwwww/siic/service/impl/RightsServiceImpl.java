package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.RightsMapper;
import com.hwwwww.siic.service.RightsService;
import com.hwwwww.siic.vo.Rights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsServiceImpl extends ServiceImpl<RightsMapper, Rights> implements RightsService {

    @Autowired
    RightsMapper dao;

    @Override
    public List<Rights> getallRights() {
        return dao.getallright1();
    }
}
