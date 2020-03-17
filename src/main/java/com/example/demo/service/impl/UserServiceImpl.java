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
    public void addUser(String studentId, String userName, Integer sex, Integer role, String mobile, String grade, String major, String gradeClass, String password, String question, String answer) {
        User user = new User();
        user.setStudentId(studentId);
        user.setUserName(userName);
        user.setSex(sex);
        user.setRole(role);
        user.setMobile(mobile);
        user.setGrade(grade);
        user.setMajor(major);
        user.setGradeClass(gradeClass);
        user.setPassword(password);
        user.setQuestion(question);
        user.setAnswer(answer);

        userMapper.addUser(user);
    }

    @Override
    public Integer updatePassword(String password, String studentId) {
        User user = new User();
        user.setStudentId(studentId);
        user.setPassword(password);

        return userMapper.updatePassword(user);
    }

    @Override
    public Integer updateQuestion(String question, String answer, String studentId) {
        User user = new User();
        user.setStudentId(studentId);
        user.setQuestion(question);
        user.setAnswer(answer);

        return null;
    }
}
