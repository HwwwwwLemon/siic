package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.NurseLevelContent;

import java.util.List;
import java.util.Map;

public interface NurseLevelContentService extends IService<NurseLevelContent> {
    Map<String, Object> selectNurseLevelContentByNurseLevelId(Map<String, Object> params);

    List<Map<String, Object>> selectNurseLevelContentByNurseLevelId(Integer nurseLevelId);

    boolean insert(NurseLevelContent entity);

    boolean update(NurseLevelContent entity);

    boolean delete(Integer id);
}

