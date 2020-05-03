package com.example.demo.service;

import com.example.demo.vo.response.CommentVO;

public interface CommentService {

    Integer addComment(Integer commentUserId, String userName, String comment);

    Integer deleteComment(Integer id);

    CommentVO getAllComment(Integer nowPage, Integer pageSize);

    CommentVO.CommentVo getCommentById(Integer id);

    Integer getCount();
}
