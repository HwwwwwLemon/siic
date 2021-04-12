package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 床位信息
 */
@Data
@TableName(value = "bed")
public class Bed implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableLogic
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(value = "building_id")
    public Integer buildingId;
    /**
     * 房间号
     */
    @TableField(value = "room_number")
    private String roomNumber;

    /**
     * 床位状态： 空闲 外出 有人
     */
    @TableField(value = "bed_status")
    private String bedStatus;

    /**
     * 床位位置（未使用）
     */
    @TableField(value = "position_type")
    private String positionType;

    /**
     * 床位名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 排序（未使用）
     */
    @TableField(value = "sort")
    private Integer sort;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_ROOM_NUMBER = "room_number";

    public static final String COL_BED_STATUS = "bed_status";

    public static final String COL_POSITION_TYPE = "position_type";

    public static final String COL_NAME = "name";

    public static final String COL_SORT = "sort";
}