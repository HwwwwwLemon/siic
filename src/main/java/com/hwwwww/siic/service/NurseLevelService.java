package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.NurseLevel;
import com.hwwwww.siic.vo.Selector;

import java.util.List;
import java.util.Map;

public interface NurseLevelService extends IService<NurseLevel> {

    Map<String, Object> selectNurseLevelWithPage(Map<String, Object> params);

    List<Selector> selectNurseLevelSelector();

    boolean insert(NurseLevel entity);

    boolean update(NurseLevel entity);

    boolean delete(Integer id);
}
