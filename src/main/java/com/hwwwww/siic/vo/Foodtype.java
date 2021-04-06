package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "foodtype")
public class Foodtype {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "is_deleted")
    private Integer isDeleted;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_IS_DELETED = "is_deleted";
}