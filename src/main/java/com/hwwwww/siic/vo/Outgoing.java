package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "outgoing")
public class Outgoing {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(value = "customerid")
    private Integer customerid;

    @TableField(value = "outgoing_reason")
    private String outgoingReason;

    @TableField(value = "outgoing_time")
    private Date outgoingTime;

    @TableField(value = "expected_return_time")
    private Date expectedReturnTime;

    @TableField(value = "actual_return_time")
    private Date actualReturnTime;

    @TableField(value = "escorted")
    private String escorted;

    @TableField(value = "relation")
    private String relation;

    @TableField(value = "escorted_tel")
    private String escortedTel;

    @TableField(value = "audit_status")
    private String auditStatus;

    @TableField(value = "audit_person")
    private String auditPerson;

    @TableField(value = "audit_tine")
    private Date auditTine;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CUSTOMERID = "customerid";

    public static final String COL_OUTGOING_REASON = "outgoing_reason";

    public static final String COL_OUTGOING_TIME = "outgoing_time";

    public static final String COL_EXPECTED_RETURN_TIME = "expected_return_time";

    public static final String COL_ACTUAL_RETURN_TIME = "actual_return_time";

    public static final String COL_ESCORTED = "escorted";

    public static final String COL_RELATION = "relation";

    public static final String COL_ESCORTED_TEL = "escorted_tel";

    public static final String COL_AUDIT_STATUS = "audit_status";

    public static final String COL_AUDIT_PERSON = "audit_person";

    public static final String COL_AUDIT_TINE = "audit_tine";
}