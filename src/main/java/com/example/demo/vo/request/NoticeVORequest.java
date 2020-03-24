package com.example.demo.vo.request;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-24 21:54
 */
@Data
public class NoticeVORequest {
    private Integer id;
    private Integer createUserId;
    private String content;
}
