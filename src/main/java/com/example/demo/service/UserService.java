package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
}
