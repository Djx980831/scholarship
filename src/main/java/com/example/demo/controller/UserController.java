package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import com.example.demo.vo.response.UserVO;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import static com.example.demo.constant.ErrorConsant.*;

@Api(tags = "用户接口", value = "实现用户的相关操作")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Producer kaptchaProducer;

    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学号", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userName", value = "姓名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "sex", value = "性别", required = true, dataType = "int"),
            @ApiImplicitParam(name = "role", value = "角色", required = true, dataType = "int"),
            @ApiImplicitParam(name = "mobile", value = "电话", required = true, dataType = "string"),
            @ApiImplicitParam(name = "grade", value = "年级", required = true, dataType = "string"),
            @ApiImplicitParam(name = "major", value = "专业", required = true, dataType = "string"),
            @ApiImplicitParam(name = "gradeClass", value = "班级", required = true, dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string"),
            @ApiImplicitParam(name = "question", value = "密保问题", required = true, dataType = "string"),
            @ApiImplicitParam(name = "answer", value = "密保答案", required = true, dataType = "string")
    })
    @PostMapping("/addUser")
    public RpcResponse<String> addUser(String studentId, String userName, Integer sex, Integer role, String mobile, String grade, String major, String gradeClass, String password, String question, String answer) {
        if (!ParamUtil.checkString(studentId, userName, mobile, grade, major, gradeClass, password, question, answer)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }
        if (!ParamUtil.checkStudentId(studentId)) {
            return RpcResponse.error(STUDENTID_IS_ERROR);
        }
        if (!ParamUtil.checkNumbers(sex, role)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }
        User user = userService.getUserByStudentIdOrMobile(studentId);
        if (user != null) {
            return RpcResponse.error(STUDENTID_IS_EXIST);
        }
        user = userService.getUserByStudentIdOrMobile(mobile);
        if (user != null) {
            return RpcResponse.error(MOBILE_IS_EXIST);
        }
        userService.addUser(studentId, userName, sex, role, mobile, grade, major, gradeClass, password, question, answer);
        return RpcResponse.success(studentId);
    }

    @PostMapping("/updatePassword")
    public RpcResponse<String> updatePassword(String password, String studentId) {
        if (!ParamUtil.checkString(password)) {
            return RpcResponse.error(PASSWORD_IS_EMPTY);
        }
        if (!ParamUtil.checkString(studentId)) {
            return RpcResponse.error(STUDENTID_IS_EMPTY);
        }
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
            return RpcResponse.error(USER_MOBILE_IS_EXIST);
        }
        userService.updateMobileByStudentId(mobile, studentId);
        return RpcResponse.success(studentId);
    }

    @PostMapping("/updateQuestionByStudentId")
    public RpcResponse<String> updateQuestionByStudentId(String question, String answer, String studentId) {
        if (!ParamUtil.checkString(answer)) {
            return RpcResponse.error(ANSWER_IS_EMPTY);
        }
        userService.updateQuestion(question, answer, studentId);
        return RpcResponse.success(studentId);
    }

    @PostMapping("login")
    public RpcResponse<String> login (String studentIdOrMobile, String password, String kaptcha,  HttpSession session) {
        if (!ParamUtil.checkString(studentIdOrMobile)) {
            return RpcResponse.error(STUDENTID_OR_MOBILE_IS_EMPTY);
        }
        if (!ParamUtil.checkString(password)) {
            return RpcResponse.error(PASSWORD_IS_EMPTY);
        }
        if (!ParamUtil.checkString(kaptcha)) {
            return RpcResponse.error(USER_YANZHENGMA_IS_EMPTY);
        }
        if (!session.getAttribute("kaptcha").equals(kaptcha)) {
            return RpcResponse.error(USER_YANZHENGMA_IS_ERROR) ;
        }
        UserVO userVO = userService.login(studentIdOrMobile, password);
        if (userVO == null) {
            return RpcResponse.error(LOGIN_ERROR);
        }
        session.setAttribute("userVO", userVO);
        Cookie id = new Cookie("id", userVO.getId().toString());
        Cookie studentId = new Cookie("studentId", userVO.getStudentId());
        Cookie userName = new Cookie("userName", userVO.getUserName());
        Cookie grade = new Cookie("grade", userVO.getGrade());
        Cookie major = new Cookie("major", userVO.getMajor());
        Cookie gradeClass = new Cookie("gradeClass", userVO.getGradeClass());
        Cookie role = new Cookie("role", userVO.getRole().toString());

        return RpcResponse.success(userVO.getStudentId());
    }

    @PostMapping("/logout")
    public RpcResponse<String> logout(HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("userVO");
        session.invalidate();
        Cookie studentId = new Cookie("studentId", null);
        studentId.setMaxAge(0);
        Cookie userName = new Cookie("userName", null);
        userName.setMaxAge(0);
        Cookie grade = new Cookie("grade", null);
        grade.setMaxAge(0);
        Cookie major = new Cookie("major", null);
        major.setMaxAge(0);
        Cookie gradeClass = new Cookie("gradeClass", null);
        gradeClass.setMaxAge(0);
        Cookie role = new Cookie("role", null);
        role.setMaxAge(0);
        return RpcResponse.success(userVO.getStudentId());
    }

    @PostMapping("/getUserByStudentIdOrMobile")
    public RpcResponse<User> getUserByStudentIdOrMobile(String studentIdOrMobile) {
        if (!ParamUtil.checkString(studentIdOrMobile)) {
            return RpcResponse.error(STUDENTID_OR_MOBILE_IS_EMPTY);
        }
        User user = userService.getUserByStudentIdOrMobile(studentIdOrMobile);
        return RpcResponse.success(user);
    }

    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学号", required = true, dataType = "string")
    })
    @PostMapping("/checkStudentId")
    public RpcResponse<Boolean> checkStudentId(String studentId) {
        if (!ParamUtil.checkString(studentId)) {
            return RpcResponse.error(STUDENTID_IS_EMPTY);
        }
        if (!ParamUtil.checkStudentId(studentId)) {
            return RpcResponse.error(STUDENTID_IS_ERROR);
        }

        return RpcResponse.success(true);
    }

    @GetMapping("/getKaptcha")
    public void getKaptcha(HttpServletResponse response, HttpSession session) {
        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);

        // 将验证码存入session
        session.setAttribute("kaptcha", text);

        // 将突图片输出给浏览器
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            System.out.println("响应验证码失败:" + e.getMessage());
        }
    }
}
