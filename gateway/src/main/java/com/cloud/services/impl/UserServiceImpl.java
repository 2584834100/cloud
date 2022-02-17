package com.cloud.services.impl;

import com.cloud.dao.UserMapper;
import com.cloud.entity.User;
import com.cloud.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean user(User user) {
        String password = userMapper.getPassword(user.getUserName());
        return user.getPassword().equals(password);
    }
}
