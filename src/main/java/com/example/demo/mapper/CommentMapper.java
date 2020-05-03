package com.example.demo.mapper;

import com.example.demo.entity.Comment;
import com.example.demo.vo.request.CommentVORequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    Integer addComment(CommentVORequest request);

    Integer deleteComment(CommentVORequest request);

    List<Comment> getAllComment(CommentVORequest request);

    Comment getCommentById(Integer id);

    Integer getCount();
}
