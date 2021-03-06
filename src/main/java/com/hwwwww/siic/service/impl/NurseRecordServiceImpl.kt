package com.hwwwww.siic.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.hwwwww.siic.mapper.NurseRecordMapper
import com.hwwwww.siic.service.NurseRecordService
import com.hwwwww.siic.vo.NurseRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.collections.HashMap

@Service
open class NurseRecordServiceImpl : ServiceImpl<NurseRecordMapper?, NurseRecord?>(), NurseRecordService {
    @Autowired
    private lateinit var customerService: CustomerServiceImpl

    override fun selectNurseRecordByCustomerName(params: Map<String, Any>?): Map<String, Any>? {
        val result: MutableMap<String, Any> = HashMap(2)
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
        val list: List<Map<String, Any>>? = baseMapper?.selectNurseContentWithCustomerName(queryWrapper)
        //获取查询到的总数
        val pageInfo = PageInfo(list)
        result["totalCount"] = pageInfo.total
        result["list"] = list as Any
        return result
    }

    override fun selectNurseRecordTodayPlanByCustomerNameAndDate(params: Map<String, Any>?): List<Map<String, Any>>? {
        if (params?.size!! <= 0) {
            return null
        }
        val id: Int = try {
            (params["id"] as String).toInt()
        } catch (e: Exception) {
            params["id"] as Int
        }

        val contentName = params["contentName"] as String
        return baseMapper?.selectNurseRecordTodayPlan(id, "$contentName%")
    }

    override fun selectNurseRecord2ExcelData(params: Map<String, Any>?, key: Int): List<Map<String, Any>>? {
        val name: List<String>?
        //按照名字搜索
        when (key) {
            1 -> name = (params?.get("name") as String).split(",")
            2 -> name = customerService.selectCustomerNames()
            else -> {
                throw RuntimeException("")
            }
        }
        //按照日期搜索
        val startTime = params?.get("startTime") as String
        val endTime = params["endTime"] as String
        val queryWrapper: QueryWrapper<Map<String, Any>> = QueryWrapper<Map<String, Any>>()
        queryWrapper.`in`("customer_name", name)
        queryWrapper.between("createtime", "$startTime 00:00:00", "$endTime 23:59:59")
        return baseMapper?.selectNurseContentWithCustomerName(queryWrapper)
    }


    override fun insert(entity: NurseRecord?): Boolean {
        //判断完成次数
        val map: Map<String, Any>? = baseMapper?.selectDoneTimes(entity?.customerid, entity?.contentid)
        val times: Int = map?.get("times") as Int ?: 0
        val doneTimes: Long = map["doneTimes"] as Long ?: 0
        if (times <= doneTimes) return false
        return this.save(entity)
    }

    override fun update(entity: NurseRecord?): Boolean {
        return this.updateById(entity)
    }

    override fun delete(id: Int): Boolean {
        return this.removeById(id)
    }
}