package com.cg.mybatis.mapper;

import com.cg.mybatis.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名获取用户对象
     * @param loginName 用户名
     * @return 返回用户对象
     */
    User selectByLoginName(String loginName);
}