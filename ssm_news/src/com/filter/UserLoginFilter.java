package com.filter;

import com.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserLoginFilter")
public class UserLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        User user = (User) request.getSession().getAttribute("user");
        String path = request.getServletPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        System.out.println("Filter拦截到"+path);
        if (user!=null || "/login.jsp".equals(path) || "/user/login".equals(path) || "/register.jsp".equals(path)||"/news/registerUser".equals(path) || "/userMain.jsp".equals(path)||"/user/out".equals(path)
        ||"NewsJson.jsp".equals(path)||"error.jsp".equals(path)){
            chain.doFilter(request, response);
        }else {
            response.sendRedirect(basePath+"login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
