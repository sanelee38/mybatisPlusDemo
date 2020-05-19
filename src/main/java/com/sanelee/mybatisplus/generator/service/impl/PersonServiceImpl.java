package com.sanelee.mybatisplus.generator.service.impl;

import com.sanelee.mybatisplus.generator.entity.Person;
import com.sanelee.mybatisplus.generator.mapper.PersonMapper;
import com.sanelee.mybatisplus.generator.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sanelee
 * @since 2020-05-19
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
