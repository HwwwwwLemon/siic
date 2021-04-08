package com.hwwwww.siic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.vo.CustomerFood;
import com.hwwwww.siic.mapper.CustomerFoodMapper;
import com.hwwwww.siic.service.CustomerFoodService;
@Service
public class CustomerFoodServiceImpl extends ServiceImpl<CustomerFoodMapper, CustomerFood> implements CustomerFoodService{

}
