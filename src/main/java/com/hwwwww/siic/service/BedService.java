package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.Bed;
import com.hwwwww.siic.vo.Selector;

import java.util.List;
import java.util.Map;

public interface BedService extends IService<Bed> {

    /**
     * 获取所有的房间号
     *
     * @return 选项list
     */
    List<Selector> selectRoomNumber();

    List<Bed> selectBedWithFloorNumber(Integer floor);

    List<Bed> selectBedWithRoomNumber(Integer roomNumber);

    List<Bed> selectBedWithCustomerName(String name);

    List<Bed> selectBedWithBedId(String bedInfo);

    Map<String, Object> selectBedInfoWithBuildingNumberRoomNumber(Map<String, Object> params);

    /**
     * 通过房间号获取当前房间床位信息
     * 床位的状态{@code getBedStatus}
     *
     * @param roomNumber 房间号
     * @param key        床位状态
     * @return 床位信息list
     */
    List<Bed> selectBedInfoWithRoomNumber(Integer roomNumber, Integer key);

    /**
     * 获取床位信息
     *
     * @param id 床位id
     * @return床位信息
     */
    Bed selectBedInfoWithBedId(Integer id);

    /**
     * 获取床位选项
     * 默认为空闲
     *
     * @param roomNumber 房间号
     * @return 选项list
     */
    List<Selector> selectBedOptions(Integer roomNumber);

    /**
     * 修改房间床位的状态
     *
     * @param id  床位的id
     * @param key 1为空闲 2为有人 3为外出
     * @return 是否成功
     */
    boolean changeBedStatus(Integer id, Integer key);

    boolean insert(Bed entity);

    boolean update(Bed entity);

    boolean delete(Integer id);
}
