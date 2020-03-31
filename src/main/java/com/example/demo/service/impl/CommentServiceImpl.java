package com.example.demo.service.impl;

import com.example.demo.entity.Comment;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import com.example.demo.util.PageInfo;
import com.example.demo.vo.request.CommentVORequest;
import com.example.demo.vo.response.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-31 22:30
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper mapper;

    @Override
    public Integer addComment(String userName, String comment) {
        CommentVORequest request = new CommentVORequest();
        request.setComment(comment);
        request.setUserName(userName);

        return mapper.addComment(request);
    }

    @Override
    public Integer updateComment(Integer id, String reply, String replyUserName, Integer flag) {
        CommentVORequest request = new CommentVORequest();
        request.setId(id);
        request.setReply(reply);
        request.setReplyUserName(replyUserName);
        request.setFlag(flag);

        mapper.updateComment(request);
        return id;
    }

    @Override
    public CommentVO getAllComment(Integer nowPage, Integer pageSize) {
        CommentVORequest request = new CommentVORequest();
        request.setNowPage(nowPage);
        request.setPageSize(pageSize);

        List<Comment> commentList = mapper.getAllComment(request);
        if (commentList == null) {
            return null;
        }
        CommentVO commentVO = new CommentVO();
        List<CommentVO.CommentVo> commentVoList = new ArrayList<>(15);
        for (Comment comment : commentList) {
            CommentVO.CommentVo vo = new CommentVO.CommentVo();
            vo.setUserName(comment.getUserName());
            vo.setComment(comment.getComment());
            vo.setCreateTime(comment.getCreateTime());
            if (comment.getReply() != null) {
                vo.setReplyUserName(comment.getReplyUserName());
                vo.setReplyTime(comment.getReplyTime());
                vo.setReply(comment.getReply());
            }

            commentVoList.add(vo);
        }

        Integer count = getCount();

        PageInfo pageInfo = new PageInfo(count, nowPage, pageSize);

        commentVO.setCommentVoList(commentVoList);
        commentVO.setPageInfo(pageInfo);

        return commentVO;
    }

    @Override
    public Comment getCommentById(Integer id) {
        return mapper.getCommentById(id);
    }

    @Override
    public Integer getCount() {
        return mapper.getCount();
    }
}
