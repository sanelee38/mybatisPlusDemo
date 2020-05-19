package com.sanelee.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author sanelee
 * @date 2020/5/18
 **/
public enum StatusEnum {
    WORK(1,"上班"),
    REST(0,"休息");


    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    @EnumValue
    private Integer code;
    private String msg;

}
