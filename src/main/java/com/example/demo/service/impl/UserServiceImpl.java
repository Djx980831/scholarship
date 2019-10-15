package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String id) {
        return userMapper.getUser(Integer.valueOf(id));
    }

    @Override
    public List<User> getAllUser() {
       return userMapper.getAllUser();
    }

    @Override
    public Integer updateUserById(String id, String userName, String password, String realName) {
        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setPassword(password);
        user.setRealName(realName);
        user.setUserName(userName);
        return userMapper.updateUserById(user);
    }
}
