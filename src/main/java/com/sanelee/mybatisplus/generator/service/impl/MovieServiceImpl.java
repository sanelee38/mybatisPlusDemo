package com.sanelee.mybatisplus.generator.service.impl;

import com.sanelee.mybatisplus.generator.entity.Movie;
import com.sanelee.mybatisplus.generator.mapper.MovieMapper;
import com.sanelee.mybatisplus.generator.service.MovieService;
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
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

}
