package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "bed")
public class Bed {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(value = "room_number")
    private String roomNumber;

    @TableField(value = "bed_status")
    private String bedStatus;

    @TableField(value = "position_type")
    private String positionType;

    @TableField(value = "name")
    private String name;

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