package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.BedMapper;
import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.vo.Bed;
import com.hwwwww.siic.vo.Selector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {


    @Override
    public boolean changeBedStatus(Integer id, Integer key) {
        Bed bed = this.getById(id);
        bed.setBedStatus(getBedStatus(key));
        return this.updateById(bed);
    }

    @Override
    public List<Selector> selectRoomNumber() {
        List<Integer> selectR = baseMapper.selectRoomNumber();
        List<Selector> result = new ArrayList<>();
        for (Integer id : selectR) {
            result.add(new Selector(id, id));
        }
        return result;
    }

    @Override
    public List<Selector> selectBedOptions(Integer roomNumber) {
        List<Bed> selectR = this.selectBedInfoWithRoomNumber(roomNumber, 1);
        List<Selector> result = new ArrayList<>();
        for (Bed bed : selectR) {
            result.add(new Selector(bed.getName(), bed.getId()));
        }
        return result;
    }


    @Override
    public List<Bed> selectBedInfoWithRoomNumber(Integer roomNumber, Integer key) {
        QueryWrapper<Bed> wrapper = new QueryWrapper<>();
        wrapper.eq("room_number", roomNumber).eq("bed_status", getBedStatus(key));
        return baseMapper.selectList(wrapper);
    }

    @Override
    public Bed selectBedInfoWithBedId(Integer id) {
        return baseMapper.selectById(id);
    }

    private String getBedStatus(Integer key) {
        switch (key) {
            case 1:
                return "空闲";
            case 2:
                return "有人";
            case 3:
                return "外出";
            default:
                throw new RuntimeException("床位状态修改失败!");
        }
    }
}
