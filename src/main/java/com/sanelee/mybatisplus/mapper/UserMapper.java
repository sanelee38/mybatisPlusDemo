package com.sanelee.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sanelee.mybatisplus.entity.ProductVO;
import com.sanelee.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sanelee
 * @date 2020/5/18
 **/

public interface UserMapper extends BaseMapper<User> {
    @Select("select p.*,u.name userName from product p,user u where p.user_id=u.id and u.id = #{id};")
    List<ProductVO> productList(Integer id);
}
