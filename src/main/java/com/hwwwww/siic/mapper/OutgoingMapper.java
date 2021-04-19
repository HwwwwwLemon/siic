package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;import com.hwwwww.siic.vo.OutGoing;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import org.apache.ibatis.annotations.Select;import java.util.List;import java.util.Map;

@Mapper
public interface OutgoingMapper extends BaseMapper<OutGoing> {
    @Select("select c.id cid,customer_name,c.customer_age,customer_sex ,o.* from customer c,outgoing o " +
            "${ew.customSqlSegment} and c.is_deleted = 1 and o.is_deleted = 1 and c.id = o.customerid")
    List<Map<String, Object>> selectOutGoingByCustomerName(@Param(Constants.WRAPPER) Wrapper<Map<String, Object>> userWrapper);
}