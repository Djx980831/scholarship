package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.constant.UserConsant.PARAM_NOT_ENOUGH;

@Api(tags = "用户接口", value = "实现用户的相关操作")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public RpcResponse<String> addUser(String studentId, String userName, Integer sex, Integer role, String mobile, String grade, String major, String gradeClass, String password, String question, String answer) {
        if (!ParamUtil.checkString(studentId, userName, mobile, grade, major, gradeClass, password, question, answer)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }
        if (!ParamUtil.checkNumbers(sex, role)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }

        userService.addUser(studentId, userName, sex, role, mobile, grade, major, gradeClass, password, question, answer);
        return RpcResponse.success(studentId);
    }

    @PostMapping("/updatePassword")
    public Integer updatePassword(String password, String studentId) {
        return userService.updatePassword(password, studentId);
    }
}
