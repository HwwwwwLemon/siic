package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
     * 护理级别ID
     */
    @TableField(value = "nurse_level_id")
    private Integer nurseLevelId;

    /**
     * 护理内容ID
     */
    @TableField(value = "nurse_content_id")
    private Integer nurseContentId;

    /**
     * 1-已删除 0未删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    public static final String COL_ID = "id";

    public static final String COL_NURSE_LEVEL_ID = "nurse_level_id";

    public static final String COL_NURSE_CONTENT_ID = "nurse_content_id";

    public static final String COL_IS_DELETED = "is_deleted";
}