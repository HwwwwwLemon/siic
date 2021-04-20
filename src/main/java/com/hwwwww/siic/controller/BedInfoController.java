package com.hwwwww.siic.controller;

import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.BedInfoService;
import com.hwwwww.siic.service.BedService;
import com.hwwwww.siic.vo.Bed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/20 9:56
 */
@RestController
@RequestMapping("bed-info")
public class BedInfoController {
    @Autowired
    private BedService bedService;
    @Autowired
    private BedInfoService service;


    @RespBodyResMapping("/get-bed-info")
    public List<Bed> getRoom(@RequestParam Map<String, Object> params) {
        String key = (String) params.get("key");
        int searchType = Integer.parseInt((String) params.get("searchType"));
        switch (searchType) {
            case 0:
                return bedService.selectBedWithFloorNumber(Integer.parseInt(key));
            case 1:
                return bedService.selectBedWithCustomerName(key);
            case 2:
                return bedService.selectBedWithRoomNumber(Integer.parseInt(key));
            case 3:
                return bedService.selectBedWithBedId(key);
            default:
                return null;
        }

    }

    @RespBodyResMapping("/get-person-info")
    public Map<String, Object> getInfo(Integer id) {
        return service.selectInfo(id);

    }
}
