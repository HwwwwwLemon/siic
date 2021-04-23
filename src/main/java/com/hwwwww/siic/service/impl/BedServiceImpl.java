package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwwwww.siic.mapper.BedMapper;
import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.service.CustomerService;
import com.hwwwww.siic.utils.MyLogger;
import com.hwwwww.siic.vo.Bed;
import com.hwwwww.siic.vo.Customer;
import com.hwwwww.siic.vo.Selector;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {
    @Autowired
    private CustomerService customerService;

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
    public List<Bed> selectBedWithFloorNumber(Integer floor) {
        QueryWrapper<Bed> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("room_number", floor);
        return this.list(queryWrapper);
    }

    @Override
    public List<Bed> selectBedWithCustomerName(String name) {
        List<Customer> customers = customerService.list(new QueryWrapper<Customer>().eq("customer_name", name));
        List<Integer> bedId = new LinkedList<>();
        if (customers.size() <= 0) {
            return null;
        }
        for (Customer customer : customers) {
            bedId.add(customer.getBedId());
        }
        return this.listByIds(bedId);
    }

    @Override
    public List<Bed> selectBedWithRoomNumber(Integer roomNumber) {
        return this.list(new QueryWrapper<Bed>().eq("room_number", roomNumber));
    }

    @Override
    public List<Bed> selectBedWithBedId(String bedInfo) {
        if (bedInfo.indexOf('-') < 0) {
            return null;
        }
        String[] temp = bedInfo.split("-");
        return this.list(new QueryWrapper<Bed>().eq("room_number", temp[0]).eq("name", temp[1]));
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
    public Map<String, Object> selectBedInfoWithBuildingNumberRoomNumber(Map<String, Object> params) {

        Map<String, Object> result = new HashMap<>(2);
        QueryWrapper<Bed> wrapper = new QueryWrapper<>();
        //当前页码
        int currentPage = Integer.parseInt((String) params.get("currentPage"));
        //每页数
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        Object buildingId = params.get("buildingId");
        Object roomNumber = params.get("roomNumber");
        wrapper.likeRight("building_id", buildingId).likeRight("room_number", roomNumber);
        //分页
        PageHelper.startPage(currentPage, pageSize);
        List<Bed> beds = baseMapper.selectList(wrapper);
        //获取查询到的总数
        PageInfo<Bed> pageInfo = new PageInfo<>(beds);
        result.put("totalCount", pageInfo.getTotal());
        result.put("list", beds);
        return result;
    }

    @Override
    public List<Bed> selectBedInfoWithRoomNumber(Integer roomNumber, Integer key) {
        QueryWrapper<Bed> wrapper = new QueryWrapper<>();
        wrapper.eq("room_number", roomNumber).eq("bed_status", getBedStatus(key));
        return baseMapper.selectList(wrapper);
    }

    @Override
    public boolean insert(Bed entity) {
        return this.save(entity);
    }

    @Override
    public boolean update(Bed entity) {
        return updateById(entity);
    }

    @Override
    public boolean delete(Integer id) {
        Bed bed = this.getById(id);
        if ("空闲".equals(bed.getBedStatus())) {
            return this.removeById(id);
        }
        return false;
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
