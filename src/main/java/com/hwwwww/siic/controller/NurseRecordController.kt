package com.hwwwww.siic.controller

import com.hwwwww.siic.annotation.RespBodyResMapping
import com.hwwwww.siic.service.impl.NurseRecordServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ResponseBody
@RequestMapping("nurse-record")
open class NurseRecordController {

    @Autowired
    private lateinit var service: NurseRecordServiceImpl

    @RespBodyResMapping("query")
    open fun query(@RequestParam params: Map<String, Any>?): Map<String, Any>? {
        return service.selectNurseRecordByCustomerName(params)
    }

}