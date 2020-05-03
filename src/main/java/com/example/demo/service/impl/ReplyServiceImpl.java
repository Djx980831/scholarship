package com.example.demo.service.impl;

import com.example.demo.entity.Reply;
import com.example.demo.mapper.ReplyMapper;
import com.example.demo.service.ReplyService;
import com.example.demo.util.PageInfo;
import com.example.demo.vo.request.ReplyVORequest;
import com.example.demo.vo.response.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-03 12:03
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper mapper;

    @Override
    public Integer addReplyByCommentId(Integer commentId, String reply, Integer replyUserId, String replyUserName) {
        ReplyVORequest request = new ReplyVORequest();
        request.setCommentId(commentId);
        request.setReply(reply);
        request.setReplyUserName(replyUserName);
        request.setReplyUserId(replyUserId);

        mapper.addReplyByCommentId(request);

        return request.getId();
    }

    @Override
    public Integer deleteReplyById(Integer id) {
        ReplyVORequest request = new ReplyVORequest();
        request.setId(id);

        mapper.deleteReplyById(request);
        return id;
    }

    @Override
    public ReplyVO getAllReply(Integer commentId, Integer nowPage, Integer pageSize) {
        ReplyVORequest request = new ReplyVORequest();
        request.setCommentId(commentId);
        request.setNowPage((nowPage - 1) * pageSize);
        request.setPageSize(pageSize);

        List<Reply> replyList= mapper.getAllReply(request);
        if (replyList == null) {
            return null;
        }

        ReplyVO replyVO = new ReplyVO();
        List<ReplyVO.ReplyVo> replyVoList = new ArrayList<>(15);
        for (Reply reply : replyList) {
            ReplyVO.ReplyVo vo = new ReplyVO.ReplyVo();
            vo.setId(reply.getId());
            vo.setCommentId(reply.getCommentId());
            vo.setReply(reply.getReply());
            vo.setReplyUserName(reply.getReplyUserName());
            vo.setCreateTime(reply.getCreateTime().toString().substring(0, 10));
            vo.setReplyUserId(reply.getReplyUserId());

            replyVoList.add(vo);
        }

        Integer count = mapper.getCountByCommentId(request);
        PageInfo pageInfo = new PageInfo(count, nowPage, pageSize);

        replyVO.setPageInfo(pageInfo);
        replyVO.setReplyVoList(replyVoList);

        return replyVO;
    }

    @Override
    public Reply getReplyByReplyId(Integer id) {
        return mapper.getReplyByReplyId(id);
    }
}
