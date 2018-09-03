package com.cg.controller;
import com.cg.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;

import com.cg.mybatis.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/registerUser")
    public String registerUser(){
        return "redirect:/jsp/pre/register.jsp";
    }
    @RequestMapping("/toLogin")
    public String login(){
        return "redirect:/jsp/pre/login.jsp";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(String password, String loginName, HttpSession session){
        Map map =  new HashMap();
        User user = userService.login(loginName,password);
        if (user != null ){
            session.setAttribute("loginUser",user);
            map.put("status",1);
            System.out.println(user);
            return map;
        }else {
            map.put("message","账号或者密码错误");
        }
        return map;
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Object register(User user){
        System.out.println(user);
        Map map = new HashMap();
//        User user1 = userService.login(user.getLoginName(), user.getPassword());
//        if (user != null){
//            map.put("message","账号已经存在");
//            return map;
//        }
        Integer count =  userService.saveUser(user);
        System.out.println(count);
        if (count ==1) {
            map.put("status", 1);
            map.put("message", "注册成功");
        }
        System.out.println(map.toString());
        return map;
    }

    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session){

        session.removeAttribute("loginUser");
        return "redirect:/toLogin.action";
    }

    /**
     * 会员中心中用户信息查询
     * @param model
     * @return
     */
    @RequestMapping("/sys/userInfo")
    public String userInfo(Model model){
        model.addAttribute("menu",2);
        return "/jsp/backend/user/userInfo.jsp";
    }
}
