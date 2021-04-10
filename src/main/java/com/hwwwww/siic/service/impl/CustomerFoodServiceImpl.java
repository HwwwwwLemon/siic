package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.CustomerFoodMapper;
import com.hwwwww.siic.service.CustomerFoodService;
import com.hwwwww.siic.vo.CustomerFood;
import org.springframework.stereotype.Service;
@Service
public class CustomerFoodServiceImpl extends ServiceImpl<CustomerFoodMapper, CustomerFood> implements CustomerFoodService{

}
