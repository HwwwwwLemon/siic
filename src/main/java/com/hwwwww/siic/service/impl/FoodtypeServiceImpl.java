package com.hwwwww.siic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.vo.Foodtype;
import com.hwwwww.siic.mapper.FoodtypeMapper;
import com.hwwwww.siic.service.FoodtypeService;
@Service
public class FoodtypeServiceImpl extends ServiceImpl<FoodtypeMapper, Foodtype> implements FoodtypeService{

}
