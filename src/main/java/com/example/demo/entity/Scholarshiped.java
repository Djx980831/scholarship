package com.example.demo.entity;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-08 22:47
 */
@Data
public class Scholarshiped {
    private Integer id;
    private Integer applyId;
    private String studentId;
    private String userName;
    private String year;
    private String grade;
    private String major;
    private String gradeClass;
    private String type;
    private Double jiaQuan;
    private Double zongHe;
    private String caoXIng;
    private Integer flag;
}
