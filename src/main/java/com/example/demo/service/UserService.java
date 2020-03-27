package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.vo.response.UserVO;

public interface UserService {

    void addUser(String studentId, String userName, Integer sex, Integer role, String mobile, String grade, String major, String gradeClass, String password, String question, String answer);

    String updatePassword(String password, String studentId);

    String updateQuestion(String question, String ar, String studentId);

    String updateMobileByStudentId(String mobile, String studentId);

    UserVO login(String studentIdOrMobile, String password);

    Integer isExistStudentId(String studenId);

    Integer isExistMobile(String mobile);

    User getUserByStudentIdOrMobile(String studentIdOrMobile);
}
