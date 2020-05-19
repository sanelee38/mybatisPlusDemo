package com.sanelee.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sanelee.mybatisplus.entity.User;
import com.sanelee.mybatisplus.enums.AgeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @author sanelee
 * @date 2020/5/18
 **/
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    void test(){
        mapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save(){
        User user = new User();
        user.setId(35L);
        user.setTitle("杜少");
        user.setAge(1);
        mapper.insert(user);
        System.out.println(user);
    }

    @Test
    void update(){
        User user = mapper.selectById(13L);
        user.setTitle("哈登");
        user.setAge(3);


//        User user1 = mapper.selectById(13L);
//        user1.setTitle("哈登2");
//        user.setAge(AgeEnum.THREE);
//
//        mapper.updateById(user1);
        mapper.updateById(user);
    }

    @Test
    void delete(){
        mapper.deleteById(1);
    }

    @Test
    void select(){
        //不加任何条件直接全部查询
//        mapper.selectList(null);
//        QueryWrapper wrapper = new QueryWrapper();
//        Map<String ,Object> map = new HashMap<>();
//        map.put("name","哈登");
//        map.put("age","2");
//        wrapper.allEq(map);
        //小于
//        wrapper.lt("age",3);
        //大于
//        wrapper.gt("age",2);
        //不等于
//        wrapper.ne("name","哈登");
        //大于等于
//        wrapper.ge("age",2);
        //模糊查询
        /**
         * likeLeft == like "%少"
         * likeRight == like "少%"
         */
//        wrapper.like("name","少");
        //联合查询inSql
//        wrapper.inSql("id","select id from user where id <38");
//        wrapper.inSql("age","select age from user where age >3");
        //排序
//        wrapper.orderByAsc("age");
//        wrapper.having("id>8");
//        mapper.selectList(wrapper).forEach(System.out::println);
        //多个Id查询
        mapper.selectBatchIds(Arrays.asList(1,13,35)).forEach(System.out::println);
    }
}