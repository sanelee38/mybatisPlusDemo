package com.sanelee.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.sanelee.mybatisplus.enums.AgeEnum;
import com.sanelee.mybatisplus.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author sanelee
 * @date 2020/5/18
 **/
@Data
@TableName(value = "user")
public class User {
    @TableId(type = IdType.INPUT)
    private Long id;
    @TableField(value = "name")
    private String title;
    private Integer age;
    @TableField(exist = false)
    private String gender;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;
    private StatusEnum status;
    @TableLogic
    private Integer deleted;

}
