package com.example.demo.controller;

import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户接口", value = "实现用户的相关操作")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public void addUser(String studentId, String userName, Integer sex, Integer role, String mobile, String grade, String major, String gradeClass, String password, String question, String answer){
        userService.addUser(studentId, userName, sex, role, mobile, grade, major, gradeClass, password, question, answer);
    }
}
