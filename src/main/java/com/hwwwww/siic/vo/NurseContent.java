package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "nurse_content")
public class NurseContent {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "price")
    private Double price;

    @TableField(value = "desc")
    private String desc;

    /**
     * 是否增值服务 1-是 0-不是 
     */
    @TableField(value = "is_add")
    private Integer isAdd;

    /**
     * 1-启用 0-不启用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 1-已删除 0未删除
     */
    @TableField(value = "id_deleted")
    private Integer idDeleted;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_PRICE = "price";

    public static final String COL_DESC = "desc";

    public static final String COL_IS_ADD = "is_add";

    public static final String COL_STATUS = "status";

    public static final String COL_ID_DELETED = "id_deleted";
}