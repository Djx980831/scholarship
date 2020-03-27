package com.example.demo.interceptor;

import com.example.demo.vo.response.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-27 23:30
 */
@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(true);
        UserVO userVO = (UserVO) session.getAttribute("userVO");
        if (null != userVO) { //已登录
            return true;
        } else {//未登录
            //直接重定向到登录页面
            // todo 指定跳转页
            response.sendRedirect(request.getContextPath() + "/wechatplatformuser/loginRBAC.html");
            return false;
        }
    }
}
