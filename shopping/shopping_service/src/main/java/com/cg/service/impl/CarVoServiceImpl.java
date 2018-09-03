package com.cg.service.impl;

import com.cg.mybatis.mapper.OrderDetailMapper;
import com.cg.mybatis.mapper.OrderMapper;
import com.cg.mybatis.mapper.ProductMapper;
import com.cg.mybatis.pojo.*;
import com.cg.service.CarVoService;
import com.cg.service.UserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;


@Service("carVoService")
public class CarVoServiceImpl implements CarVoService {

    @Resource(name = "productMapper")
    private ProductMapper productMapper;

    /**
     * 将商品添加到购物车中
     * 思路：前台传来一个CartVo大购物车 如果这个购物车是null就新建一个购物车
     * 新建一个cart 这个小cart是存放一种商品的  ，还有一种商品的数量
     * 这样将前台传来的商品id和商品数量存入就好
     *
     * @param entityId 商品id
     * @param quantity 商品数量
     * @param cartVo   这个是车
     * @return
     */
    @Override
    public CartVo addCart(Integer entityId, Integer quantity, CartVo cartVo) {
        if (cartVo == null) {
            cartVo = new CartVo();
        }
        Product product = productMapper.selectByPrimaryKey(entityId); //从数据库中查询处商品
        for (Cart c : cartVo.getItems()) {
            if (product.getId().equals(c.getProduct().getId())) {
                c.setQuantity(c.getQuantity() + 1);
                c.setCost(c.getCost() + product.getPrice());
                return cartVo;
            }
        }

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setQuantity(quantity);
        cart.setCost(product.getPrice() * quantity);
        cartVo.getItems().add(cart);
        return cartVo;
    }

    @Override
    public CartVo caluSum(CartVo cartVo) {
        Float sum = 0.0f;
        for (Cart c: cartVo.getItems()) {
            sum+=c.getProduct().getPrice()*c.getQuantity();

        }
        cartVo.setSum(sum);

        return cartVo;
    }

    @Resource(name = "userAddressService")
    private UserAddressService userAddressService;
    @Resource(name = "orderMapper")
    private OrderMapper orderMapper;
    @Resource(name =  "orderDetailMapper")
    private OrderDetailMapper orderDetailMapper;
    @Override
    public Order addOrder(Integer addressId, String newAddress, String newRemark, User user, CartVo cart) {
        UserAddress userAddress = userAddressService.confirmAddress(addressId, newAddress, newRemark, user);

        Order order = new Order();
        order.setCost(cart.getSum());
        order.setUserId(user.getId());
        Date date = new Date();
        order.setCreateTime(date);
        order.setLoginName(user.getLoginName());
        order.setUserAddress(userAddress.getAddress());
        UUID uuid = UUID.randomUUID();
        order.setSerialNumber(uuid.toString());
        orderMapper.insertSelective(order);

        for (Cart vo : cart.getItems()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setCost(vo.getCost());
            orderDetail.setQuantity(vo.getQuantity());
            orderDetail.setOrderId(order.getId());
            orderDetail.setProductId(vo.getProduct().getId());
            orderDetailMapper.insertSelective(orderDetail);
        }
        return order;
    }

    @Override
    public CartVo updateCart(Integer entityId, Integer quantity, CartVo cart) {
        if (quantity == 0){
            for (Cart vo : cart.getItems()) {
                if (vo.getProduct().getId().equals(entityId)){
                    cart.getItems().remove(vo);
                    cart = caluSum(cart);
                    return cart;
                }
            }
        }
        for (Cart vo : cart.getItems()){
            if (vo.getProduct().getId().equals(entityId)){
                vo.setQuantity(quantity);
                vo.setCost(vo.getProduct().getPrice()*quantity);
                cart = caluSum(cart);
                return cart;
            }
        }
        return cart;
    }
}


