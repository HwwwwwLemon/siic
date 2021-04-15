package com.hwwwww.siic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwwwww.siic.annotation.RespBodyResMapping;
import com.hwwwww.siic.service.FoodService;
import com.hwwwww.siic.vo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/12 21:08
 */
@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService service;
    @Autowired
    private Environment environment;

    @RespBodyResMapping("/get-with-date")
    public Map<String, List<Food>> getBySupplyDate(Integer supplyDate, Integer key) {
        return service.selectFoodByDay(supplyDate, key);
    }

    @RespBodyResMapping("/add")
    public boolean addFood(Food food) {
        return service.insert(food);
    }

    @RespBodyResMapping("/update")
    public boolean updateFood(Food food) {
        return service.update(food);
    }

    @RespBodyResMapping("/del")
    public boolean deleteFood(Integer id) {
        return service.delete(id);
    }

    @RespBodyResMapping("get-by-id")
    public String getFoodById(Integer id) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>(1);
        map.put("food", service.getById(id));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

    @RespBodyResMapping("get-by-id-list")
    public String getFoodByIdList(@RequestBody List<Integer> idList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(service.getFoodByIdList(idList));
    }

    @RespBodyResMapping("get-quantity")
    public Map<String, Object> getFoodQuantity(@RequestParam Map<String, Object> params) throws JsonProcessingException {
        return service.selectFoodQuantity(params);
    }


    @RespBodyResMapping(value = "/uploads")
    public Map<String, Object> file(@RequestParam("file") MultipartFile file, @RequestParam("path") String path) throws IOException {
        String originName = "";
        String netPicPath = "";
        int code = 500;
        Map<String, Object> map = new HashMap<>(2);
        String filePath = ResourceUtils.getURL("classpath:static").getPath() + "/";
        if (file != null) {
            originName = file.getOriginalFilename();
            File foodPic = new File(filePath + path + originName);
            file.transferTo(foodPic);
            if (foodPic.exists()) {
                netPicPath = "http://localhost:" + environment.getProperty("local.server.port") + "/" + path + originName;
                code = 200;
            }
        }
        map.put("pic_path", netPicPath);
        map.put("code", code);
        return map;
    }
}
