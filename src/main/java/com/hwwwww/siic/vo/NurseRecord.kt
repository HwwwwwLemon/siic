package com.hwwwww.siic.vo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableLogic
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

data class NurseRecord(
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null,

    /**
     * 0-已删除 1未删除
     */
    @TableLogic
    @TableField(value = "is_deleted")
    var isDeleted: Int? = null,
    /**
     * 客户id
     */
    @TableField(value = "customerid")
    var customerid: Int? = null,
    /**
     * 操作员id
     */
    @TableField(value = "userid")
    var userid: Int? = null,

    /**
     * 护理内容id
     */
    @TableField(value = "contentid")
    var contentid: Int? = null,

    /**
     * 护理时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "createtime")
    var createtime: Date? = null,

){
}
