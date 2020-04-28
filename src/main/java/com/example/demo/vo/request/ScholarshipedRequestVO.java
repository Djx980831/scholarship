package com.example.demo.vo.request;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-08 23:30
 */
@Data
public class ScholarshipedRequestVO {
    private String studentId;
    private String year;
    private String grade;
    private String major;
    private String type;
    private String sortKind;
    private Integer nowPage;
    private Integer pageSize;
}
