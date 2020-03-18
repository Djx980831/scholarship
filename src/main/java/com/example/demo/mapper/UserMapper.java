package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    void addUser(User user);

    String updatePassword(User user);

    String updateQuestion(User user);

    Integer isExistStudentId(String studentId);

    Integer isExistMobile(String mobile);

    String login(String studentIdOrMobile, String password);
}
