package com.cg.mybatis.mapper;

import com.cg.mybatis.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 根据用户id获取订单
     * @param userId  用户id
     * @return 返回订单集合
     */
    List<Order> selectByUserId(Integer userId);

    /**
     * 获取全部订单
     * @return 返回订单集合
     */
    List<Order> selectUser();
}