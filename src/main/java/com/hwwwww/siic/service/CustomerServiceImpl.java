package com.hwwwww.siic.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.CustomerMapper;
import com.hwwwww.siic.vo.Customer;
import com.hwwwww.siic.service.CustomerService;
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService{

}
