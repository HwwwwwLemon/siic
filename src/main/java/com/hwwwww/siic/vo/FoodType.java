package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * food_type
 *
 * @author Hwwwww
 */
@Data
@TableName(value = "food_type")
public class FoodType implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableLogic
    @TableField(value = "is_deleted")
    private Integer isDeleted;
    @TableField(value = "label")
    private String label;
    @TableField(value = "type")
    private Integer type;
}