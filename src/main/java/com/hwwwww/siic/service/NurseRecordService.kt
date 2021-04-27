package com.hwwwww.siic.service

import com.baomidou.mybatisplus.extension.service.IService
import com.hwwwww.siic.vo.NurseRecord

interface NurseRecordService : IService<NurseRecord?> {
    fun selectNurseRecordByCustomerName(params: Map<String, Any>?): Map<String, Any>?
}