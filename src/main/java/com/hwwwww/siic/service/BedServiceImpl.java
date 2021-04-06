package com.hwwwww.siic.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.vo.Bed;
import com.hwwwww.siic.mapper.BedMapper;
import com.hwwwww.siic.service.BedService;
@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService{

}
