package com.example.demo.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-03 11:33
 */
@Data
public class Reply {
    private Integer id;
    private Integer commentId;
    private String reply;
    private Integer replyUserId;
    private String replyUserName;
    private Timestamp createTime;
}
