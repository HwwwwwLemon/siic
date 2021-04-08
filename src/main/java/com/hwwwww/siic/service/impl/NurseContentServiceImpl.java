package com.hwwwww.siic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.vo.NurseContent;
import com.hwwwww.siic.mapper.NurseContentMapper;
import com.hwwwww.siic.service.NurseContentService;
@Service
public class NurseContentServiceImpl extends ServiceImpl<NurseContentMapper, NurseContent> implements NurseContentService{

}
