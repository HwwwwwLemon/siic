package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
    private Integer foodid;

    /**
     * 膳食日期
     */
    @TableField(value = "fooddate")
    private Date fooddate;

    /**
     * 膳食星期
     */
    @TableField(value = "foodweek")
    private Integer foodweek;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CUSTOMERID = "customerid";

    public static final String COL_FOODID = "foodid";

    public static final String COL_FOODDATE = "fooddate";

    public static final String COL_FOODWEEK = "foodweek";
}