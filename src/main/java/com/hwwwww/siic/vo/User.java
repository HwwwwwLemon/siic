package com.hwwwww.siic.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "`user`")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "create_by")
    private Integer createBy;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "update_by")
    private Integer updateBy;

    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "email")
    private String email;

    @TableField(value = "phone_number")
    private String phoneNumber;

    @TableField(value = "user_code")
    private String userCode;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_SEX = "sex";

    public static final String COL_EMAIL = "email";

    public static final String COL_PHONE_NUMBER = "phone_number";

    public static final String COL_USER_CODE = "user_code";
}