package com.example.demo.service;

import com.example.demo.vo.response.CommentVO;

public interface CommentService {

    Integer addComment(String userName, String comment);

    Integer updateComment(Integer id, String reply, String replyUserName, Integer flag);

    CommentVO getAllComment(Integer nowPage, Integer pageSize);

    CommentVO.CommentVo getCommentById(Integer id);

    Integer getCount();
}
