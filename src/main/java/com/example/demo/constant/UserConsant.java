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
}
