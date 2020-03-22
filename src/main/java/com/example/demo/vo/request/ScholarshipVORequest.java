package com.example.demo.vo.request;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-22 23:38
 */
@Data
public class ScholarshipVORequest {
    private Integer id;
    private String name;
    private Integer money;
    private Integer count;
    private String classCount;
    private String description;
}
