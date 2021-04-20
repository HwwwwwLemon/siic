package com.hwwwww.siic.service;

import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/20 14:20
 */
public interface BedInfoService {
    /**
     * 利用客户id,获取客户基本信息,护理等级信息,膳食备注,注意事项
     *
     * @param id id
     * @return 键值对
     */
    Map<String, Object> selectInfo(Integer id);
}
