package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.Rights;

import java.util.List;

public interface RightsService extends IService<Rights> {

    public List<Rights> getallRights();


}
