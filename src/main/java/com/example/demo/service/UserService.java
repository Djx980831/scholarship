package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    List<User> getAllUser();

    Integer updateUserById(String id, String userName, String password, String realName);
}
