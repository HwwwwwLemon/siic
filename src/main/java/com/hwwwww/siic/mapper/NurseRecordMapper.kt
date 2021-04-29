package com.hwwwww.siic.mapper

import com.baomidou.mybatisplus.core.conditions.Wrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.toolkit.Constants
import com.hwwwww.siic.vo.NurseRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface NurseRecordMapper : BaseMapper<NurseRecord?> {
    @Select(
        "select nr.id nrid, nr.createtime, u.nickname, c.customer_name, c.id cid, nc.name, nc.`desc` description " +
                "from customer c,user u,nurse_content nc,nurse_record nr " +
                " \${ew.customSqlSegment} and nc.is_deleted = 1 and c.is_deleted = 1 and u.is_deleted = 1 and nr.is_deleted =1  and c.id = nr.customerid and u.id = nr.userid and nc.id = nr.contentid order by nr.createtime"
    )
    fun selectNurseContentWithCustomerName(@Param(Constants.WRAPPER) userWrapper: Wrapper<Map<String, Any>>): List<Map<String, Any>>

    @Select(
        "select t.*, max(r.id) rid, max(r.createtime) as createtime,count(r.contentid) as doneTimes from " +
                "(select c.id, c.customer_name, nc.name, nc.id as contentid,nc.`desc`, nlc.cycle,nlc.times, nlc.remarks from nurse_level_content nlc,nurse_content nc,customer c " +
                "where c.nurse_level = nlc.nurse_level_id and nlc.nurse_content_id = nc.id and nc.is_deleted = 1 and c.is_deleted = 1 and nlc.is_deleted = 1 and c.id = #{id} and nc.name like #{contentName}) t " +
                "left join nurse_record r on r.contentid = t.contentid and r.is_deleted = 1  and t.id = r.customerid  and (r.createtime is null or date(r.createtime)=CURRENT_DATE) " +
                "group by contentid"
    )
    fun selectNurseRecordTodayPlan(id: Int?,contentName:String): List<Map<String, Any>>

    @Select(
        "select nlc.times, count(nr.contentid) as doneTimes\n" +
                "from customer c\n" +
                "    left join nurse_level_content nlc on c.nurse_level = nlc.nurse_level_id and nlc.nurse_content_id = #{contentId}\n" +
                "         left join nurse_record nr\n" +
                "                   on (nr.createtime is null or date(nr.createtime) = CURRENT_DATE) and c.id = nr.customerid and\n" +
                "                      nr.contentid = nlc.nurse_content_id\n" +
                "where c.id = #{id} and (nr.is_deleted = 1 or nr.is_deleted is null)\n" +
                "group by nr.contentid;"
    )
    fun selectDoneTimes(id: Int?, contentId: Int?): Map<String, Any>
}