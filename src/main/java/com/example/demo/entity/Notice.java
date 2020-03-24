package com.example.demo.entity;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-24 21:56
 */
@Data
public class Notice {
    private Integer id;
    private Integer createUserId;
    private String content;
    private Integer flag;
}
