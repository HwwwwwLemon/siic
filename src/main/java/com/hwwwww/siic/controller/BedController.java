package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.vo.Bed;
import com.hwwwww.siic.vo.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/9 15:00
 */
@RestController()
@RequestMapping("/bed")
public class BedController {
    @Autowired
    private BedService service;


    @RespBodyResMapping("/query")
    public Map<String, Object> getByRoomNumberBedNumber(@RequestParam Map<String, Object> map) throws JsonProcessingException {

        return service.selectBedInfoWithBuildingNumberRoomNumber(map);
    }

    @RespBodyResMapping("/get-by-id")
    public Map<String, Object> getById(Integer id) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>(1);
        map.put("bed", service.getById(id));
        return map;
    }

    @RespBodyResMapping("/get-room-number")
    public List<Selector> getRoomNumber() throws JsonProcessingException {
        return service.selectRoomNumber();

    }

    @RespBodyResMapping("/get-bed-number")
    public List<Selector> getBedNumber(@RequestParam(value = "roomNumber") Integer roomNumber) throws JsonProcessingException {
        return service.selectBedOptions(roomNumber);

    }

    @RespBodyResMapping("/add")
    public boolean addBed(Bed bed) {
        return service.insert(bed);
    }

    @RespBodyResMapping("/update")
    public boolean updateBed(Bed bed) {
        return service.update(bed);
    }

    @RespBodyResMapping("/del")
    public boolean deleteBed(Integer id) {
        return service.delete(id);
    }
}
