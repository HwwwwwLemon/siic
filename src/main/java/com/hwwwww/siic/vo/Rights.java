package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "rights")
@JsonIgnoreProperties(value = {"handler"})
public class Rights {
    public static final String COL_ID = "id";
    public static final String COL_AUTHNAME = "authname";
    public static final String COL_LEVEL = "level";
    public static final String COL_PID = "pid";
    public static final String COL_PATH = "path";
    public static final String COL_ISDELETED = "isdeleted";
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "authname")
    private String authname;
    @TableField(value = "`level`")
    private Integer level;
    @TableField(value = "pid")
    private Integer pid;
    @TableField(value = "`path`")
    private String path;
    private List<Rights> children;
    @TableField(value = "isdeleted")
    @TableLogic
    private Integer isdeleted;
}