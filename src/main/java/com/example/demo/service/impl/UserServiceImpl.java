package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.util.ParamUtil;
import com.example.demo.vo.response.UserVO;
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
    public String updatePassword(String password, String studentId) {
        User user = new User();
        user.setStudentId(studentId);
        user.setPassword(password);

        userMapper.updatePassword(user);
        return studentId;
    }

    @Override
    public String updateQuestion(String question, String answer, String studentId) {
        User user = new User();
        user.setStudentId(studentId);
        user.setQuestion(question);
        user.setAnswer(answer);

        userMapper.updateQuestion(user);
        return studentId;
    }

    @Override
    public String updateMobileByStudentId(String mobile, String studentId) {
        User user = new User();
        user.setMobile(mobile);
        user.setStudentId(studentId);

        userMapper.updateMobileByStudentId(user);
        return studentId;
    }

    @Override
    public UserVO login(String studentIdOrMobile, String password) {
        return userMapper.login(studentIdOrMobile, password);
    }

    @Override
    public Integer isExistStudentId(String studenId) {
        return userMapper.isExistStudentId(studenId);
    }

    @Override
    public Integer isExistMobile(String mobile) {
        return userMapper.isExistMobile(mobile);
    }

    @Override
    public User getUserByStudentIdOrMobile(String studentIdOrMobile) {
        return userMapper.getUserByStudentIdOrMobile(studentIdOrMobile);
    }

    @Override
    public String getQuestionByStudentId(String studentId) {
        return userMapper.getQuestionByStudentId(studentId);
    }

    @Override
    public String getAnswerByStudentId(String studentId, String answer) {
        return userMapper.getAnswerByStudentId(studentId, answer);
    }
}
