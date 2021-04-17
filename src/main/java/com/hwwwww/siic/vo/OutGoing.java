package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 外出登记
 */
@Data
@TableName(value = "outgoing")
public class OutGoing implements Serializable {
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
     * 外出原因
     */
    @TableField(value = "outgoing_reason")
    private String outgoingReason;

    /**
     * 外出时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "outgoing_time")
    private Date outgoingTime;

    /**
     * 预计回来时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "expected_return_time")
    private Date expectedReturnTime;

    /**
     * 实际回来时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "actual_return_time")
    private Date actualReturnTime;

    /**
     * 陪同人
     */
    @TableField(value = "escorted")
    private String escorted;

    /**
     * 与老人关系
     */
    @TableField(value = "relation")
    private String relation;

    /**
     * 陪同人电话
     */
    @TableField(value = "escorted_tel")
    private String escortedTel;

    /**
     * 审批状态
     */
    @TableField(value = "audit_status")
    private String auditStatus;

    /**
     * 审批人
     */
    @TableField(value = "audit_person")
    private String auditPerson;

    /**
     * 审批时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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