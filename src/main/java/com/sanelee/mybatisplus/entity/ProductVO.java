package com.sanelee.mybatisplus.entity;

import lombok.Data;

/**
 * @author sanelee
 * @date 2020/5/19
 **/
@Data
public class ProductVO {
    private Integer category;
    private Integer count;
    private String description;
    private Integer userId;
    private String userName;

}
