package com.cg.controller;

import com.cg.mybatis.pojo.Order;
import com.cg.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    /**
     * 根据用户id查询订单
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/getOrderById")
    public String getOrderById(Integer userId , Model model){

        List<Order> orderList = orderService.getOrderByUserId(userId);

        model.addAttribute("orderList",orderList);
        return "/jsp/backend/order/orderList.jsp";
    }
    @RequestMapping("/sys/getAllOrder")
    public String getAllOrder( Model model){

        List<Order> orderList = orderService.getAllOrder();

        model.addAttribute("orderList",orderList);
        return "/jsp/backend/order/orderList.jsp";
    }
    @RequestMapping("/sys/queryOrderDeatil")
    public String queryOrderDeatil(Integer orderId , Model model){

        Order  order  = orderService.getOrderById(orderId);

        model.addAttribute("order",order);
        return "/jsp/backend/order/orderList.jsp";
    }


}
