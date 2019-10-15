package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User getUser(@Param("id") int id);

    List<User> getAllUser();

    Integer updateUserById(User user);
}
