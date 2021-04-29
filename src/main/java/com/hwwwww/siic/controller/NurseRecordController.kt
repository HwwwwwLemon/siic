package com.hwwwww.siic.controller

import com.hwwwww.siic.annotation.RespBodyResMapping
import com.hwwwww.siic.service.impl.CustomerServiceImpl
import com.hwwwww.siic.service.impl.NurseRecordServiceImpl
import com.hwwwww.siic.utils.EasyExcelUtilsKt
import com.hwwwww.siic.vo.NurseRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletResponse

@Controller
@ResponseBody
@RequestMapping("/nurse-record")
open class NurseRecordController {

    @Autowired
    private lateinit var service: NurseRecordServiceImpl

    private val titleNames: Array<String> =
        arrayOf("护理Id", "客户Id", "客户姓名", "护理时间", "护理名称", "护理描述", "护理人员")
    private val listKeys: Array<String> =
        arrayOf("nrid", "cid", "customerName", "createtime", "name", "description", "nickname")

    @RespBodyResMapping("/query")
    open fun query(@RequestParam params: Map<String, Any>?): Map<String, Any>? {
        return service.selectNurseRecordByCustomerName(params)
    }

    @RespBodyResMapping("/query-plan")
    open fun queryPlan(@RequestParam params: Map<String, Any>?): List<Map<String, Any>>? {
        return service.selectNurseRecordTodayPlanByCustomerNameAndDate(params)
    }

    @RespBodyResMapping("/get-person-data-excel")
    open fun nurseRecordToExcelOneCustomer(resp: HttpServletResponse, @RequestParam params: Map<String, Any>?) {
        EasyExcelUtilsKt().download(resp, "record", titleNames, listKeys, service.selectNurseRecord2ExcelData(params,1));
    }
    @RespBodyResMapping("/get-all-person-data-excel")
    open fun allNurseRecordToExcelOneCustomer(resp: HttpServletResponse, @RequestParam params: Map<String, Any>?) {
        EasyExcelUtilsKt().download(resp, "record", titleNames, listKeys, service.selectNurseRecord2ExcelData(params,2));
    }

    @RespBodyResMapping("/add")
    open fun addNurseRecord(nurseRecord: NurseRecord): Boolean {
        return service.insert(nurseRecord)
    }

    @RespBodyResMapping("/update")
    open fun updateNurseRecord(nurseRecord: NurseRecord): Boolean {
        return service.update(nurseRecord)
    }

    @RespBodyResMapping("/del")
    open fun deleteNurseRecord(id: Int): Boolean {
        return service.delete(id)
    }
}