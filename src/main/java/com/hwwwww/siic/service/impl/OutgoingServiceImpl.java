package com.hwwwww.siic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.vo.Outgoing;
import com.hwwwww.siic.mapper.OutgoingMapper;
import com.hwwwww.siic.service.OutgoingService;
@Service
public class OutgoingServiceImpl extends ServiceImpl<OutgoingMapper, Outgoing> implements OutgoingService{

}
