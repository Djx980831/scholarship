package com.example.demo.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-31 22:28
 */
@Data
public class Comment {
    private Integer id;
    private String userName;
    private String comment;
    private Timestamp createTime;
    private Integer flag;
}
