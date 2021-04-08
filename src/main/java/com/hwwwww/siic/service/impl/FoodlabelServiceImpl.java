package com.hwwwww.siic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.vo.Foodlabel;
import com.hwwwww.siic.mapper.FoodlabelMapper;
import com.hwwwww.siic.service.FoodlabelService;
@Service
public class FoodlabelServiceImpl extends ServiceImpl<FoodlabelMapper, Foodlabel> implements FoodlabelService{

}
