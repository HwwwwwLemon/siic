package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.OutGoing;

import java.util.Map;

/**
 * @author Hwwwww
 */
public interface OutgoingService extends IService<OutGoing> {
    Map<String, Object> selectOutGoingWithPage(Map<String, Object> params) throws Exception;

}
