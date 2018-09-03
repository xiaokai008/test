package com.cg.service.impl;

import com.cg.mybatis.mapper.UserAddressMapper;
import com.cg.mybatis.pojo.User;
import com.cg.mybatis.pojo.UserAddress;
import com.cg.service.UserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {
    @Resource(name = "userAddressMapper")
    private UserAddressMapper userAddressMapper;
    @Override
    public List<UserAddress> getList(Integer userId) {

        return userAddressMapper.selectAll(userId);
    }

    @Override
    public UserAddress confirmAddress(Integer addressId, String newAddress, String newRemark, User user) {
        UserAddress userAddress = userAddressMapper.selectByPrimaryKey(addressId);
        if (userAddress == null){
            userAddress = new UserAddress();
            userAddress.setAddress(newAddress);
            userAddress.setRemark(newRemark);
            userAddress.setUserId(user.getId());
            userAddressMapper.insertSelective(userAddress);
        }
        return userAddress;
    }
}
