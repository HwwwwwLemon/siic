package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.NurseLevel;

import java.util.Map;

public interface NurseLevelService extends IService<NurseLevel> {

    Map<String, Object> selectNurseLevelWithPage(Map<String, Object> params);

    boolean insert(NurseLevel entity);

    boolean update(NurseLevel entity);

    boolean delete(Integer id);
}
