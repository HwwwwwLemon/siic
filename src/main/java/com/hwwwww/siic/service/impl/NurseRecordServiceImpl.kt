package com.hwwwww.siic.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.hwwwww.siic.mapper.NurseRecordMapper
import com.hwwwww.siic.service.NurseRecordService
import com.hwwwww.siic.vo.NurseRecord
import org.springframework.stereotype.Service

@Service
open class NurseRecordServiceImpl : ServiceImpl<NurseRecordMapper?, NurseRecord?>(), NurseRecordService {

    override fun selectNurseRecordByCustomerName(params: Map<String, Any>?): Map<String, Any>? {
        val result: MutableMap<String, Any> = HashMap(2)
        params?.entries?.forEach(::println)
        //当前页码
        val currentPage: Int = (params?.get("currentPage") as String).toInt()
        //每页数
        val pageSize: Int = (params["pageSize"] as String).toInt()
        //按照名字搜索
        val name = (params["name"] as String).split(",")
        //按照日期搜索
        val nurseTime = params["nurseTime"] as String
        //分页
        val queryWrapper: QueryWrapper<Map<String, Any>> = QueryWrapper<Map<String, Any>>()
        queryWrapper.`in`("customer_name", name)
        queryWrapper.likeRight("createtime", nurseTime)
        PageHelper.startPage<Any?>(currentPage, pageSize)
        val customers: List<Map<String, Any>>? = baseMapper?.selectNurseContentWithCustomerName(queryWrapper)
        //获取查询到的总数
        val pageInfo = PageInfo(customers)
        result["totalCount"] = pageInfo.total
        result["list"] = customers as Any
        return result
    }
}