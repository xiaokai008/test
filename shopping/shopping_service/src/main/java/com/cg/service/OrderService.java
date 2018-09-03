package com.cg.service;

import com.cg.mybatis.pojo.Order;

import java.util.List;

public interface OrderService {


    /**
     * 获取全部订单
     * @return 返回订单集合
     */
    List<Order> getAllOrder();
    /**
     * 根据用户id获取订单
     * @param userId 用户id/
     * @return 订单集合
     */
    List<Order> getOrderByUserId(Integer userId);

    /**
     * 根据订单号获取订单
     * @param orderId 订单号
     * @return 返回订单对象
     */
    Order getOrderById(Integer orderId);
}
