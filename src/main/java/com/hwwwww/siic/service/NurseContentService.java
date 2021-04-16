package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.NurseContent;
import com.hwwwww.siic.vo.Selector;

import java.util.List;
import java.util.Map;

public interface NurseContentService extends IService<NurseContent> {
    Map<String, Object> selectNurseContentWithPage(Map<String, Object> params);

    List<Selector> selectNurseContentSelector();

    boolean insert(NurseContent entity);

    boolean update(NurseContent entity);

    boolean delete(Integer id);
}
