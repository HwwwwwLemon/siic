package com.hwwwww.siic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.vo.Food;
import com.hwwwww.siic.mapper.FoodMapper;
import com.hwwwww.siic.service.FoodService;
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService{

}
