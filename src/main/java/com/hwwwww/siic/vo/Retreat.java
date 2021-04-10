package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
    * 退住登记
    */
@Data
@TableName(value = "retreat")
public class Retreat {
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
     * 退住时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "retreat_time")
    private Date retreatTime;

    /**
     * 退住类型
     */
    @TableField(value = "retreat_type")
    private String retreatType;

    /**
     * 退出原因
     */
    @TableField(value = "retreat_reason")
    private String retreatReason;

    /**
     * 状态：已申请，审批通过，审批未通过
     */
    @TableField(value = "`status`")
    private String status;

    /**
     * 审核意见
     */
    @TableField(value = "audit_status")
    private String auditStatus;

    /**
     * 审核人
     */
    @TableField(value = "audit_person")
    private String auditPerson;

    /**
     * 审核时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "audit_tine")
    private Date auditTine;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CUSTOMERID = "customerid";

    public static final String COL_RETREAT_TIME = "retreat_time";

    public static final String COL_RETREAT_TYPE = "retreat_type";

    public static final String COL_RETREAT_REASON = "retreat_reason";

    public static final String COL_STATUS = "status";

    public static final String COL_AUDIT_STATUS = "audit_status";

    public static final String COL_AUDIT_PERSON = "audit_person";

    public static final String COL_AUDIT_TINE = "audit_tine";
}