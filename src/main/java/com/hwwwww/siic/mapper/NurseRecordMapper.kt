package com.hwwwww.siic.mapper

import com.baomidou.mybatisplus.core.conditions.Wrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.toolkit.Constants
import com.hwwwww.siic.vo.NurseRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface NurseRecordMapper:BaseMapper<NurseRecord?> {
    @Select(
        "select nr.id nrid, nr.createtime, u.nickname, c.customer_name, c.id cid, nc.name, nc.`desc` description " +
                "from customer c,user u,nurse_content nc,nurse_record nr " +
                " \${ew.customSqlSegment}  and c.id = nr.customerid and u.id = nr.userid and nc.id = nr.contentid order by nr.createtime"
    )
    fun selectNurseContentWithCustomerName(@Param(Constants.WRAPPER) userWrapper: Wrapper<Map<String, Any>>): List<Map<String, Any>>
}