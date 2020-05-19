package com.sanelee.mybatisplus.generator.controller;


import com.sanelee.mybatisplus.generator.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sanelee
 * @since 2020-05-19
 */
@Controller
@RequestMapping("/generator/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list",movieService.list());
        return modelAndView;
    }
}

