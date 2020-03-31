package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.vo.response.CommentVO;

public interface CommentService {

    Integer addComment(String userName, String comment);

    Integer updateComment(Integer id, String reply, String replyUserName, Integer flag);

    CommentVO getAllComment(Integer nowPage, Integer pageSize);

    Comment getCommentById(Integer id);

    Integer getCount();
}
