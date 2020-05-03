package com.example.demo.controller;

import com.example.demo.entity.Reply;
import com.example.demo.service.CommentService;
import com.example.demo.service.ReplyService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import com.example.demo.vo.response.CommentVO;
import com.example.demo.vo.response.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.constant.ErrorConsant.*;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-31 23:29
 */
@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService service;

    @PostMapping("/addReplyByCommentId")
    public RpcResponse<Integer> addReplyByCommentId(Integer commentId, String reply, Integer replyUserId, String replyUserName, Integer role) {
        if (!ParamUtil.checkNumbers(commentId)) {
            return RpcResponse.error(REPLY_COMMENTID_IS_EMPTY);
        }
        if (!ParamUtil.checkString(reply)) {
            return RpcResponse.error(REPLY_REPLY_IS_EMPTY);
        }
        if (!ParamUtil.checkString(replyUserName)) {
            return RpcResponse.error(REPLY_REPLYUSERNAME_IS_EMPTY);
        }
        if (role == 1) {
            return RpcResponse.success(service.addReplyByCommentId(commentId, reply, replyUserId, replyUserName));
        }
        return RpcResponse.error(REPLY_QUANXIAN_ERROR);
    }

    @PostMapping("/deleteReplyById")
    public RpcResponse<Integer> deleteReplyById(Integer id, Integer role, Integer userId) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(REPLY_REPLYID_IS_EMPTY);
        }
        Reply reply = service.getReplyByReplyId(id);
        if (role == 1 || reply.getReplyUserId() == userId) {
            return RpcResponse.success(service.deleteReplyById(id));
        }
        return RpcResponse.error(REPLY_QUANXIAN_ERROR);
    }

    @PostMapping("/getAllReply")
    public RpcResponse<ReplyVO> getAllReply(Integer commentId, Integer nowPage, Integer pageSize) {
        if (!ParamUtil.checkNumbers(commentId)) {
            return RpcResponse.error(REPLY_COMMENTID_IS_EMPTY);
        }
        if (!ParamUtil.checkNumbers(nowPage, pageSize)) {
            return RpcResponse.error(REPLY_LIMIT_IS_EMPTY);
        }

        return RpcResponse.success(service.getAllReply(commentId, nowPage, pageSize));
    }
}
