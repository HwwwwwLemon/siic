package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "`role`")
@JsonIgnoreProperties(value = {"handler"})
public class Role {
    public static final String COL_ID = "id";
    public static final String COL_ROLENAME = "rolename";
    public static final String COL_ROLEDESC = "roledesc";
    public static final String COL_ISDELETED = "isdeleted";
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "rolename")
    private String rolename;
    @TableField(value = "roledesc")
    private String roledesc;
    private List<Rights> children;
    @TableField(value = "isdeleted")
    @TableLogic
    private Integer isdeleted;
}