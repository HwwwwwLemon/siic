package com.hwwwww.siic.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.RetreatMapper;
import com.hwwwww.siic.vo.Retreat;
import com.hwwwww.siic.service.RetreatService;
@Service
public class RetreatServiceImpl extends ServiceImpl<RetreatMapper, Retreat> implements RetreatService{

}
