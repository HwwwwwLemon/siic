package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

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

    @TableField(value = "customerid")
    private Integer customerid;

    @TableField(value = "retreat_time")
    private Date retreatTime;

    @TableField(value = "retreat_type")
    private String retreatType;

    @TableField(value = "retreat_reason")
    private String retreatReason;

    @TableField(value = "status")
    private String status;

    @TableField(value = "audit_status")
    private String auditStatus;

    @TableField(value = "audit_person")
    private String auditPerson;

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