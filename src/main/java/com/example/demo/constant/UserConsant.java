package com.example.demo.constant;

import com.example.demo.util.ErrorInfo;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-17 23:22
 */
public class UserConsant {
    private UserConsant(){};

    public static final Integer SUCCESS_CODE = 0;

    public static final ErrorInfo PARAM_NOT_ENOUGH = new ErrorInfo(100, "缺少参数");

    public static final ErrorInfo PARAM_ERROR = new ErrorInfo(101, "参数错误");

    public static final ErrorInfo STUDENTID_IS_EXIST = new ErrorInfo(102, "学号已存在，请直接登陆");

    public static final ErrorInfo MOBILE_IS_EXIST = new ErrorInfo(103, "手机号已存在，请直接登陆");

    public static final ErrorInfo STUDENTID_IS_EMPTY = new ErrorInfo(104, "学号为空");

    public static final ErrorInfo MOBILE_IS_EMPTY = new ErrorInfo(105, "手机号为空");

    public static final ErrorInfo STUDENTID_OR_MOBILE_IS_EMPTY = new ErrorInfo(106, "学号或手机号不可为空");

    public static final ErrorInfo PASSWORD_IS_EMPTY = new ErrorInfo(107, "密码不可为空");

    public static final ErrorInfo LOGIN_ERROR = new ErrorInfo(108, "学号、手机号或密码不正确，请重新输入");

    public static final ErrorInfo ANSWER_IS_EMPTY = new ErrorInfo(109, "密保答案为空");
}
