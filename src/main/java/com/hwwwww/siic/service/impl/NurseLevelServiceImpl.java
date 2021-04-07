package com.hwwwww.siic.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.NurseLevelMapper;
import com.hwwwww.siic.vo.NurseLevel;
import com.hwwwww.siic.service.NurseLevelService;
@Service
public class NurseLevelServiceImpl extends ServiceImpl<NurseLevelMapper, NurseLevel> implements NurseLevelService{

}
