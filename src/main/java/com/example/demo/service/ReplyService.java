package com.example.demo.service;

import com.example.demo.vo.response.ReplyVO;

public interface ReplyService {
    Integer addReplyByCommentId(Integer commentId, String reply, String replyUserName);

    Integer deleteReplyById(Integer id);

    ReplyVO getAllReply(Integer commentId, Integer nowPage, Integer pageSize);
}
