package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 护理级别
 */
@Data
@TableName(value = "nurse_level")
public class NurseLevel implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableLogic
    @TableField(value = "id_deleted")
    private Integer idDeleted;

    /**
     * 护理级别名称
     */
    @TableField(value = "level_name")
    private String levelName;


    /**
     * 1:启用  2 停用
     */
    @TableField(value = "level_status")
    private Integer levelStatus;

    @TableField(value = "remarks")
    private String remarks;

    public static final String COL_ID = "id";

    public static final String COL_ID_DELETED = "id_deleted";

    public static final String COL_LEVEL_NAME = "level_name";

    public static final String COL_LEVEL_STATUS = "level_status";

    public static final String COL_REMARKS = "remarks";


}