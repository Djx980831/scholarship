package com.example.demo.mapper;

import com.example.demo.entity.Reply;
import com.example.demo.vo.request.ReplyVORequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyMapper {

    Integer addReplyByCommentId(ReplyVORequest replyVORequest);

    Integer deleteReplyById(ReplyVORequest replyVORequest);

    List<Reply> getAllReply(ReplyVORequest replyVORequest);

    Integer getCountByCommentId(ReplyVORequest replyVORequest);
}
