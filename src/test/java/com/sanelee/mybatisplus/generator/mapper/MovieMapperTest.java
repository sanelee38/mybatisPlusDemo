package com.sanelee.mybatisplus.generator.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sanelee
 * @date 2020/5/19
 **/
@SpringBootTest
class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;

    @Test
    void test(){
        movieMapper.selectList(null).forEach(System.out::println);
    }
}