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
public class ReplyVORequest {
    private Integer id;
    private Integer commentId;
    private String replyUserName;
    private String reply;
    private Integer flag;
    private Integer nowPage;
    private Integer pageSize;
}
