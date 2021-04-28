package com.hwwwww.siic.controller

import com.hwwwww.siic.annotation.RespBodyResMapping
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
        val map = service.selectNurseRecordByCustomerName(params)
        val list: List<Map<String, Any>>? = map?.get("list") as List<Map<String, Any>>?
        val titleNames: Array<String> = arrayOf("护理Id", "客户Id", "客户姓名", "护理时间", "护理名称", "护理描述", "护理人员")
        //在图片的字段后面加上showImg，不然出来的是图片链接
        val listKeys: Array<String> =
            arrayOf("nrid", "cid", "customerName", "createtime", "name", "description", "nickname")
        EasyExcelUtilsKt().download(resp, "record", titleNames, listKeys, list);
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