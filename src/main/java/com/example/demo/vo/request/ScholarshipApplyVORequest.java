package com.example.demo.vo.request;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-26 22:13
 */
@Data
public class ScholarshipApplyVORequest {
    private Integer id;
    private String studentId;
    private String grade;
    private String major;
    private String gradeClass;
    private String userName;
    private String type;
    private String time;
    private String sortKind;
    private Integer nowPage;
    private Integer pageSize;
}
