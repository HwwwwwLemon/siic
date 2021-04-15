package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户膳食信息
 */
@Data
@TableName(value = "customer_food")
public class CustomerFood implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableLogic
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 客户ID
     */
    @TableField(value = "customerid")
    private Integer customerid;

    /**
     * 膳食ID
     */
    @TableField(value = "foodid")
    private String  foodid;

    /**
     * 膳食日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "fooddate")
    private Date fooddate;

    /**
     * 膳食星期
     */
    @TableField(value = "foodweek")
    private Integer foodweek;

    /**
     * 平时喜好
     */
    @TableField(value = "likes")
    private String likes;

    /**
     * 注意事项
     */
    @TableField(value = "attention")
    private String attention;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CUSTOMERID = "customerid";

    public static final String COL_FOODID = "foodid";

    public static final String COL_FOODDATE = "fooddate";

    public static final String COL_FOODWEEK = "foodweek";

    public static final String COL_LIKES = "likes";

    public static final String COL_ATTENTION = "attention";

    public static final String COL_REMARKS = "remarks";
}