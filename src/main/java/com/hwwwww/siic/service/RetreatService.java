package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.Retreat;

import java.util.List;
import java.util.Map;

public interface RetreatService extends IService<Retreat> {
    Map<String, Object> selectRetreatWithPage(Map<String, Object> params) throws Exception;

    Retreat getRetreatById(Integer id) throws Exception;

    boolean updateAudit(List<Retreat> retreatList);

    boolean insert(Retreat entity) throws Exception;

    boolean update(Retreat entity) throws Exception;

    boolean delete(Integer id);
}
