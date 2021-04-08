package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@TableName(value = "customer")
public class Customer {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableLogic
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(value = "customer_name")
    private String customerName;

    @TableField(value = "customer_age")
    private Integer customerAge;

    @TableField(value = "customer_sex")
    private String customerSex;

    @TableField(value = "idcard")
    private String idcard;

    @TableField(value = "room_number")
    private String roomNumber;

    @TableField(value = "building_id")
    private Integer buildingId;

    @TableField(value = "record_id")
    private String recordId;

    /**
     * 活力老人
     */
    @TableField(value = "elder_type")
    private String elderType;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "checkin_date")
    private Date checkinDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "expiration_date")
    private Date expirationDate;

    @TableField(value = "contact_tel")
    private String contactTel;

    @TableField(value = "bed_id")
    private Integer bedId;

    /**
     * 精神状况
     */
    @TableField(value = "psychosomatic_state")
    private String psychosomaticState;

    @TableField(value = "attention")
    private String attention;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "birthday")
    private Date birthday;

    @TableField(value = "height")
    private String height;

    /**
     * 婚姻状况
     */
    @TableField(value = "marital_status")
    private String maritalStatus;

    @TableField(value = "weight")
    private String weight;

    @TableField(value = "blood_type")
    private String bloodType;

    @TableField(value = "filepath")
    private String filepath;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CUSTOMER_NAME = "customer_name";

    public static final String COL_CUSTOMER_AGE = "customer_age";

    public static final String COL_CUSTOMER_SEX = "customer_sex";

    public static final String COL_IDCARD = "idcard";

    public static final String COL_ROOM_NUMBER = "room_number";

    public static final String COL_BUILDING_ID = "building_id";

    public static final String COL_RECORD_ID = "record_id";

    public static final String COL_ELDER_TYPE = "elder_type";

    public static final String COL_CHECKIN_DATE = "checkin_date";

    public static final String COL_EXPIRATION_DATE = "expiration_date";

    public static final String COL_CONTACT_TEL = "contact_tel";

    public static final String COL_BED_ID = "bed_id";

    public static final String COL_PSYCHOSOMATIC_STATE = "psychosomatic_state";

    public static final String COL_ATTENTION = "attention";

    public static final String COL_BIRTHDAY = "birthday";

    public static final String COL_HEIGHT = "height";

    public static final String COL_MARITAL_STATUS = "marital_status";

    public static final String COL_WEIGHT = "weight";

    public static final String COL_BLOOD_TYPE = "blood_type";

    public static final String COL_FILEPATH = "filepath";
}