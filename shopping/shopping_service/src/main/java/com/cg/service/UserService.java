package com.cg.service;

import com.cg.mybatis.pojo.User;

public interface UserService {

    /**
     * 账户注册
     * @param user  账户对象
     * @return 返回 0、1（0注册成功 1注册失败）
     */
    Integer saveUser(User user);

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    User login(String loginName, String password);
}
