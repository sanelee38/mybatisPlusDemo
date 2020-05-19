package com.sanelee.mybatisplus.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author sanelee
 * @date 2020/5/18
 **/
public enum AgeEnum implements IEnum<Integer> {
    ONE(1,"一岁"),
    TWO(2,"两岁"),
    THREE(3,"三岁");

    AgeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
