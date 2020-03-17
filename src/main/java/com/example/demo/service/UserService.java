package com.example.demo.service;

public interface UserService {

    void addUser(String studentId, String userName, Integer sex, Integer role, String mobile, String grade, String major, String gradeClass, String password, String question, String answer);

    Integer updatePassword(String password, String studentId);

    Integer updateQuestion(String question, String answer, String studentId);
}
