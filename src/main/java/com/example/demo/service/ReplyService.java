package com.example.demo.service;

import com.example.demo.entity.Reply;
import com.example.demo.vo.response.ReplyVO;

public interface ReplyService {
    Integer addReplyByCommentId(Integer commentId, String reply, Integer replyUserId, String replyUserName);

    Integer deleteReplyById(Integer id);

    ReplyVO getAllReply(Integer commentId, Integer nowPage, Integer pageSize);

    Reply getReplyByReplyId(Integer id);
}
