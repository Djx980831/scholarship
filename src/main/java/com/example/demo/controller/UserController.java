package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.constant.UserConsant.*;

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
    public RpcResponse<String> updatePassword(String password, String studentId) {
        userService.updatePassword(password, studentId);
        return RpcResponse.success(studentId);
    }

    @PostMapping("/isExistStudentId")
    public RpcResponse<String> isExistStudentId(String studentId) {
        if (!ParamUtil.checkString(studentId)) {
            return RpcResponse.error(STUDENTID_IS_EMPTY);
        }
        if (userService.isExistStudentId(studentId) != null) {
            return RpcResponse.error(STUDENTID_IS_EXIST);
        }
        return RpcResponse.success(studentId);
    }

    @PostMapping("/isExistMobile")
    public RpcResponse<String> isExistMobile(String mobile) {
        if (!ParamUtil.checkString(mobile)) {
            return RpcResponse.error(MOBILE_IS_EMPTY);
        }
        if (userService.isExistMobile(mobile) != null) {
            return RpcResponse.error(MOBILE_IS_EXIST);
        }
        return RpcResponse.success(mobile);
    }

    @PostMapping("/updateMobileByStudentId")
    public RpcResponse<String> updateMobileByStudentId(String mobile, String studentId) {
        if (!ParamUtil.checkString(mobile)) {
            return RpcResponse.error(MOBILE_IS_EMPTY);
        }
        if (userService.isExistMobile(mobile) != null) {
            return RpcResponse.error(MOBILE_IS_EXIST);
        }
        return RpcResponse.success(studentId);
    }

    @PostMapping("/updateQuestionByStudentId")
    public RpcResponse<String> updateQuestionByStudentId(String question, String answer, String studentId) {
        if (!ParamUtil.checkString(question, answer)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }
        userService.updateQuestion(question, answer, studentId);
        return RpcResponse.success(studentId);
    }

    @PostMapping("login")
    public RpcResponse<String> login (String studentIdOrMobile, String password) {
        if (!ParamUtil.checkString(studentIdOrMobile)) {
            return RpcResponse.error(STUDENTID_OR_MOBILE_IS_EMPTY);
        }
        if (!ParamUtil.checkString(password)) {
            return RpcResponse.error(PASSWORD_IS_EMPTY);
        }
        String studentId = userService.login(studentIdOrMobile, password);
        if (studentId == null) {
            return RpcResponse.error(LOGIN_ERROR);
        }
        return RpcResponse.success(studentId);

    }
}
