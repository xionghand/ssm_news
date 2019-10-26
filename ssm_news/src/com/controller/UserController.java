package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(User user, String isno, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView();
        user = userService.login(user);
        if (user!=null){
            if ("yes".equals(isno)){
                Cookie cuserId = null;
                Cookie cpassword = null;
                try {
                    cuserId = new Cookie("username", URLEncoder.encode(user.getUserId().toString(),"utf-8") );
                    cpassword = new Cookie("password",URLEncoder.encode(user.getPwd(),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                cuserId.setPath("/SSM_news");
                cpassword.setPath("/SSM_news");
                cuserId.setMaxAge(5*24*60*60);
                cpassword.setMaxAge(5*24*60*60);
                response.addCookie(cuserId);
                response.addCookie(cpassword);
            }
            session.setAttribute("user",user);
            mv.setViewName("redirect:/userMain.jsp");
        }else {
            mv.addObject("error","账户名或密码错误");
            mv.setViewName("redirect:/login.jsp");
        }
        return mv;
    }

    @RequestMapping("/out")
    public ModelAndView out(HttpSession session){
        ModelAndView mv = new ModelAndView();
        session.invalidate();
        mv.setViewName("login");
        return mv;
    }
}
