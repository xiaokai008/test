package com.cg.service;

import com.cg.mybatis.pojo.User;
import com.cg.mybatis.pojo.UserAddress;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> getList(Integer id);

    UserAddress confirmAddress(Integer addressId, String newAddress, String newRemark, User user);
}
