package com.cg.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{

    /**
     * 方法调用前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断用户是否登陆  如果没有登陆  重定向到登陆页面   不放行   如果登陆了  就放行了
        // URL  http://localhost:8080/springmvc-mybatis/login.action
        //URI /login.action
        String requestURL = request.getRequestURI();
        String username = (String) request.getSession().getAttribute("loginName");
        if (null == username){
            response.sendRedirect(request.getContextPath()+"/toLogin.action");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("方法后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

        System.out.println("页面渲染后");
    }
}
