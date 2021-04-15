package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.NurseLevel;

import java.util.Map;

public interface NurseLevelService extends IService<NurseLevel> {

   Map<String, Object> selectCustomerWithPage(Map<String, Object> params);
}
