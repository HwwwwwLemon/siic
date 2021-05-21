package com.hwwwww.siic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwwwww.siic.vo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    public List<Role> getroles(Integer id);
    @Select("select rs.path\n" +
            "from user u,role r,rights rs,role_right_r rr\n" +
            "where u.roleid = r.id and rr.roleid = r.id and u.id = #{userId} and rr.rightid = rs.id and path like #{path}\n" +
            "     and u.is_deleted = 1 and r.isdeleted = 1 and rs.isdeleted = 1 and rr.isdeleted = 1")
    public List<String> checkRole(Integer userId,String path);
}