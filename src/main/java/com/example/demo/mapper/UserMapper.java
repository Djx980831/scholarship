package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.vo.response.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    void addUser(User user);

    Integer updatePassword(User user);

    Integer updateQuestion(User user);

    Integer isExistStudentId(String studentId);

    Integer isExistMobile(String mobile);

    UserVO login(String studentIdOrMobile, String password);

    User getUserByStudentIdOrMobile(String studentIdOrMobile);

    Integer updateMobileByStudentId(User user);

    String getQuestionByStudentId(String studentId);

    String getAnswerByStudentId(String studentId, String answer);
}
