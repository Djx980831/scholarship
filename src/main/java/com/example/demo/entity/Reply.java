package com.example.demo.entity;

import lombok.Data;

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
    private String replyUserName;
}
