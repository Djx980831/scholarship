package com.example.demo.vo.request;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-31 22:33
 */
@Data
public class CommentVORequest {
    private Integer id;
    private String userName;
    private String comment;
    private Integer flag;
    private String reply;
    private String replyUserName;
    private Integer nowPage;
    private Integer pageSize;
}