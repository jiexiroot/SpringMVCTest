package com.springmvc.interceptor;

import com.springmvc.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 拦截器 拦截主页的主要功能
 * @author GOU
 * @Date 2020-06-04 16:27
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //释放跳转主页
        String url = httpServletRequest.getRequestURI();
        if(url.indexOf("/index")>=0){
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("userIF");
        //判断登陆情况
        if(user != null){
            session.removeAttribute("logIF");
            session.setAttribute("logIF","登录成功，欢迎您");
            System.out.println("已经登录");
            return true;
        }
        //未登录情况
        session.setAttribute("logIF","您还没有登陆，请先登录");
        System.out.println("未登录");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
