package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import com.example.demo.vo.response.CommentVO;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping("/addComment")
    public RpcResponse<Integer> addComment(String userName, String comment) {
        if (!ParamUtil.checkString(comment)) {
            return RpcResponse.error(COMMENT_IS_EMPTY);
        }
        return RpcResponse.success(service.addComment(userName, comment));
    }

    @PostMapping("/updateComment")
    public RpcResponse<Integer> updateComment(Integer id, String reply, String replyUserName, Integer flag) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(COMMENT_ID_IS_EMPTY);
        }
        return RpcResponse.success(service.updateComment(id, reply, replyUserName, flag));
    }

    @PostMapping("/getAllComment")
    public RpcResponse<CommentVO> getAllComment(Integer nowPage, Integer pageSize) {
        if (!ParamUtil.checkNumbers(nowPage, pageSize)) {
            return RpcResponse.error(COMMENT_LIMIT_NOT_ENOUGH);
        }
        return RpcResponse.success(service.getAllComment(nowPage, pageSize));
    }

    @PostMapping("/getCommentById")
    public RpcResponse<Comment> getCommentById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(COMMENT_ID_IS_EMPTY);
        }
        return RpcResponse.success(service.getCommentById(id));
    }
}
