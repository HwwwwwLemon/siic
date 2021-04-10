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
    * 客户信息
    */
@Data
@TableName(value = "customer")
public class Customer {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 客户姓名
     */
    @TableField(value = "customer_name")
    private String customerName;

    /**
     * 客户年龄
     */
    @TableField(value = "customer_age")
    private Integer customerAge;

    /**
     * 客户性别
     */
    @TableField(value = "customer_sex")
    private String customerSex;

    /**
     * 身份证号码
     */
    @TableField(value = "idcard")
    private String idcard;

    /**
     * 档案编号
     */
    @TableField(value = "record_id")
    private String recordId;

    /**
     * 老人类型： 活力老人 自理老人 护理老人
     */
    @TableField(value = "elder_type")
    private String elderType;

    /**
     * 入住时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "checkin_date")
    private Date checkinDate;

    /**
     * 合同到期时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "expiration_date")
    private Date expirationDate;

    /**
     * 联系电话
     */
    @TableField(value = "contact_tel")
    private String contactTel;

    /**
     * 建筑编号（未使用）
     */
    @TableField(value = "building_id")
    private Integer buildingId;

    /**
     * 房间号
     */
    @TableField(value = "room_number")
    private String roomNumber;

    /**
     * 床位id
     */
    @TableField(value = "bed_id")
    private Integer bedId;

    /**
     * 精神状况：正常 非正常
     */
    @TableField(value = "psychosomatic_state")
    private String psychosomaticState;

    /**
     * 注意事项
     */
    @TableField(value = "attention")
    private String attention;

    /**
     * 生日
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 身高
     */
    @TableField(value = "height")
    private String height;

    /**
     * 婚姻状况
     */
    @TableField(value = "marital_status")
    private String maritalStatus;

    /**
     * 体重
     */
    @TableField(value = "weight")
    private String weight;

    /**
     * 血型
     */
    @TableField(value = "blood_type")
    private String bloodType;

    /**
     * 照片地址
     */
    @TableField(value = "filepath")
    private String filepath;

    public static final String COL_ID = "id";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CUSTOMER_NAME = "customer_name";

    public static final String COL_CUSTOMER_AGE = "customer_age";

    public static final String COL_CUSTOMER_SEX = "customer_sex";

    public static final String COL_IDCARD = "idcard";

    public static final String COL_RECORD_ID = "record_id";

    public static final String COL_ELDER_TYPE = "elder_type";

    public static final String COL_CHECKIN_DATE = "checkin_date";

    public static final String COL_EXPIRATION_DATE = "expiration_date";

    public static final String COL_CONTACT_TEL = "contact_tel";

    public static final String COL_BUILDING_ID = "building_id";

    public static final String COL_ROOM_NUMBER = "room_number";

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