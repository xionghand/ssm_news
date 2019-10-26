package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice(basePackages = "com.controller")
public class ExceptionController {
    @ExceptionHandler
    public ModelAndView modelAndView(Exception e){
        ModelAndView mv = new ModelAndView();
        if (e instanceof Exception){
            mv.addObject("error","当前页面出了点小事故，正在维护中，感谢您对本站的支持");
            mv.setViewName("error");
        }
        return mv;
    }
}
