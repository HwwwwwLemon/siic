package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "role_right_r")
public class RoleRightR {
    public static final String COL_ID = "id";
    public static final String COL_ROLEID = "roleid";
    public static final String COL_RIGHTID = "rightid";
    public static final String COL_ISDELETED = "isdeleted";
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "roleid")
    private Integer roleid;
    @TableField(value = "rightid")
    private Integer rightid;
    private List<Rights> children;
    @TableField(value = "isdeleted")
    @TableLogic
    private Integer isdeleted;
}