package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.OutGoing;

import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 */
public interface OutgoingService extends IService<OutGoing> {
    Map<String, Object> selectOutGoingWithPage(Map<String, Object> params) throws Exception;

    OutGoing getOutGoingById(Integer id) throws Exception;

    boolean updateAudit(List<OutGoing> outGoingList);

    boolean insert(OutGoing entity) throws Exception;

    boolean update(OutGoing entity) throws Exception;

    boolean delete(Integer id);
}
