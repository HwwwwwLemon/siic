package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "food")
public class Food {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(value = "foodname")
    private String foodname;

    /**
     * 类别
     */
    @TableField(value = "foodtype")
    private Integer foodtype;

    /**
     * 食品标签
     */
    @TableField(value = "foodlabel")
    private Integer foodlabel;

    @TableField(value = "foodprice")
    private Double foodprice;

    /**
     * 是否清真 1-是 0-否
     */
    @TableField(value = "is_muslim")
    private Integer isMuslim;

    /**
     * 供应星期
     */
    @TableField(value = "supply_date")
    private Integer supplyDate;

    /**
     * 供应类型 1：早餐；2午餐；3晚餐
     */
    @TableField(value = "supply_type")
    private Integer supplyType;

    /**
     * 图片地址
     */
    @TableField(value = "foodpic")
    private String foodpic;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_FOODNAME = "foodname";

    public static final String COL_FOODTYPE = "foodtype";

    public static final String COL_FOODLABEL = "foodlabel";

    public static final String COL_FOODPRICE = "foodprice";

    public static final String COL_IS_MUSLIM = "is_muslim";

    public static final String COL_SUPPLY_DATE = "supply_date";

    public static final String COL_SUPPLY_TYPE = "supply_type";

    public static final String COL_FOODPIC = "foodpic";
}