package com.cg.service.impl;

import com.cg.mybatis.mapper.OrderMapper;
import com.cg.mybatis.pojo.Order;
import com.cg.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource(name = "orderMapper")
    private OrderMapper orderMapper;

    /**
     * 根据用户id获取订单
     * @param userId 用户id
     * @return 返回订单集合
     */
    @Override
    public List<Order> getOrderByUserId(Integer userId) {
       List<Order> orderList = orderMapper.selectByUserId(userId);
        return orderList;
    }

    @Override
    public Order getOrderById(Integer orderId) {

        Order order = orderMapper.selectByPrimaryKey(orderId);

        return order;

    }

    /**
     * 获取全部订单
     * @return 返回订单集合
     */
    @Override
    public List<Order> getAllOrder() {
        List<Order> orderList =  orderMapper.selectUser();
        return orderList;
    }
}
