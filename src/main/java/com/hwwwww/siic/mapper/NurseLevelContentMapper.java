package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwwwww.siic.vo.NurseLevelContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface NurseLevelContentMapper extends BaseMapper<NurseLevelContent> {
    /**
     * @param id -
     * @return -
     */
    @Select("select nlc.id, nc.name, nc.price,nlc.cycle, nlc.times, nlc.remarks, nlc.sort " +
            "from nurse_level nl, nurse_content nc, nurse_level_content nlc " +
            "where nl.id = #{id} and nlc.nurse_content_id = nc.id and nlc.nurse_level_id = nl.id " +
            "and nlc.is_deleted = 1 and nc.is_deleted = 1 and nl.is_deleted = 1")
    List<Map<String, Object>> selectNurseLevelContentByNurseLevelId(Integer id);
}