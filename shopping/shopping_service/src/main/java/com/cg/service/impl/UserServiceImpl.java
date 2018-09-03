package com.cg.service.impl;

import com.cg.mybatis.mapper.UserMapper;
import com.cg.mybatis.pojo.User;
import com.cg.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;
    //注册
    @Override
    public Integer saveUser(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        System.out.println(user.getPassword());
        int insert = userMapper.insert(user);
        return insert;
    }

//    登录
    @Override
    public User login(String loginName, String password) {
       User user = userMapper.selectByLoginName(loginName);
        if (DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
            return user;
        }
       return null ;
    }
}
