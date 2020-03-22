package com.example.demo.entity;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-20 21:18
 */
@Data
public class Scholarship {

    private Integer id;
    private String name;
    private Integer money;
    private Integer count;
    private String classCount;
    private String description;
    private Integer flag;
}
