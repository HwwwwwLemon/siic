package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 护理级别对应的护理内容
 */
@Data
@TableName(value = "nurse_level_content")
public class NurseLevelContent {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 0-已删除 1未删除
     */
    @TableLogic
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 护理级别ID
     */
    @TableField(value = "nurse_level_id")
    private Integer nurseLevelId;

    /**
     * 护理内容ID
     */
    @TableField(value = "nurse_content_id")
    private Integer nurseContentId;

    @TableField(value = "remarks")
    private String remarks;

    /**
     * 1:每小时 2:每天 3:每周 4:每月
     */
    @TableField(value = "`cycle`")
    private String cycle;

    @TableField(value = "times")
    private Integer times;

    @TableField(value = "sort")
    private Integer sort;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_NURSE_LEVEL_ID = "nurse_level_id";

    public static final String COL_NURSE_CONTENT_ID = "nurse_content_id";

    public static final String COL_REMARKS = "remarks";

    public static final String COL_CYCLE = "cycle";

    public static final String COL_TIMES = "times";

    public static final String COL_SORT = "sort";
}