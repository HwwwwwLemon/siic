package com.hwwwww.siic.service

import com.baomidou.mybatisplus.extension.service.IService
import com.hwwwww.siic.vo.NurseRecord

interface NurseRecordService : IService<NurseRecord?> {
    /**
     * 根据客户的姓名查询,用户的姓名可以是多个
     * 但是必须是 "张三,李四,王五" 这样的格式
     *
     * @param params 必须参数:当前页(currentPage),每页条目数(pageSize),客户姓名(name) 非必需参数:时间(nurseTime)
     * @return totalCount:总条目数 list:查询的结果
     */
    fun selectNurseRecordByCustomerName(params: Map<String, Any>?): Map<String, Any>?

    /**
     * 根据客户的id查询当天需要完成护理项目
     * 可以根据护理项目查询
     *
     * @param params 必须参数:客户id(id) 非必需参数:护理项目(contentName)
     * @return 结果集
     */
    fun selectNurseRecordTodayPlanByCustomerNameAndDate(params: Map<String, Any>?): List<Map<String, Any>>?

    /**
     * 根据客户的姓名将指定日期内的护理记录导出到Excel
     *
     * @param params 必须参数:客户姓名(name),时间(startTime,endTime)
     * @return 结果集
     */
    fun selectNurseRecord2ExcelData(params: Map<String, Any>?): List<Map<String, Any>>?
    fun insert(entity: NurseRecord?): Boolean
    fun update(entity: NurseRecord?): Boolean
    fun delete(id: Int): Boolean
}