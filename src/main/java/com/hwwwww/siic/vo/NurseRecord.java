package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName(value = "nurse_record")
public class NurseRecord {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 0-已删除 1未删除
     */
    @TableLogic
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 客户id
     */
    @TableField(value = "customerid")
    private Integer customerid;

    /**
     * 操作员id
     */

    @TableField(value = "userid")
    private Integer userid;

    /**
     * 护理内容id
     */
    @TableField(value = "contentid")
    private Integer contentid;

    /**
     * 护理时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "createtime")
    private Date createtime;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CUSTOMERID = "customerid";

    public static final String COL_USERID = "userid";

    public static final String COL_CONTENTID = "contentid";

    public static final String COL_CREATETIME = "createtime";
}