package com.example.demo.entity;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-26 22:06
 */
@Data
public class ScholarshipApply {
    private Integer id;
    private String studentId;
    private String grade;
    private String major;
    private String gradeClass;
    private String userName;
    private String type;
    private Integer flag;
    private Double jiaQuan;
    private Double zongHe;
    private String caoXing;
    private String jiaQuanClassRank;
    private String jiaquanMajorRank;
    private String zongHeClassRank;
    private String description;
}
