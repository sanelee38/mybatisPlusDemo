package com.sanelee.mybatisplus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickController {
    @RequestMapping("/")
    public String quick(){
        return "你好 springboot!!!";
    }
}
