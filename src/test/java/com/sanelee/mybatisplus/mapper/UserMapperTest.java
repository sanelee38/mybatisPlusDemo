package com.sanelee.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
//        User user = mapper.selectById(13L);
//        user.setTitle("哈登");
//        user.setAge(3);
//
//
////        User user1 = mapper.selectById(13L);
////        user1.setTitle("哈登2");
////        user.setAge(AgeEnum.THREE);
////
////        mapper.updateById(user1);
//        mapper.updateById(user);
        User user = mapper.selectById(36L);
        user.setTitle("斯科拉");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",2);
        mapper.update(null,wrapper);
    }

    @Test
    void delete(){
//        mapper.deleteById(1);
//        mapper.deleteBatchIds(Arrays.asList(13,37));
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("age",1);
//        mapper.delete(wrapper);
        Map<String,Object> map =new HashMap<>();
        map.put("id",23);
        mapper.deleteByMap(map);
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
//        mapper.selectBatchIds(Arrays.asList(1,13,35)).forEach(System.out::println);
        //Map只能做等值判断，逻辑判断需要用wrapper
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",37);
//        mapper.selectByMap(map).forEach(System.out::println);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",13);
//        System.out.println(mapper.selectCount(wrapper));

        //将查询的结果集封装到Map中
//        mapper.selectMaps(wrapper).forEach(System.out::println);

        //分页查询
//        Page<User> page = new Page<>(2,2);
//        Page<User> result = mapper.selectPage(page, null);
//        System.out.println(result.getSize());
//        System.out.println(result.getTotal());
//        result.getRecords().forEach(System.out::println);

//        Page<Map<String,Object>> page = new Page<>(1,2);
//        mapper.selectMapsPage(page,null).getRecords().forEach(System.out::println);
        //仅仅查询id
//        mapper.selectObjs(null).forEach(System.out::println);
        //查询单个数据
        System.out.println(mapper.selectOne(wrapper));
    }

    @Test
    void product(){
        mapper.productList(13).forEach(System.out::println);
    }
}