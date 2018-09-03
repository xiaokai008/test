package com.cg.service;

import com.cg.mybatis.pojo.CartVo;
import com.cg.mybatis.pojo.Order;
import com.cg.mybatis.pojo.User;

public interface CarVoService {

    /**
     * 添加商品到购物车
     * @param entityId
     * @param quantity
     * @param cartVo
     * @return
     */
      CartVo addCart(Integer entityId, Integer quantity,CartVo cartVo);

    /**
     * 计算和
     * @param cartVo 购物车
     * @return 返回和
     */
    CartVo caluSum(CartVo cartVo);

    Order addOrder(Integer addressId, String newAddress, String newRemark, User user, CartVo cart);

    CartVo updateCart(Integer entityId, Integer quantity, CartVo cart);

}
