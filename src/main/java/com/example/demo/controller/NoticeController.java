package com.example.demo.controller;

import com.example.demo.service.NoticeService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import com.example.demo.vo.response.NoticeVO;
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
 * @Date 2020-03-24 22:25
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService service;

    @PostMapping("/addNotice")
    public RpcResponse<Integer> addNotice(Integer createUserId, String content) {
        if (!ParamUtil.checkNumbers(createUserId)) {
            return RpcResponse.error(CREATE_USER_ID_IS_EMPTY);
        }
        if (!ParamUtil.checkString(content)) {
            return RpcResponse.error(CONTENT_IS_EMPTY);
        }
        return RpcResponse.success(service.addNotice(createUserId, content));
    }

    @PostMapping("/deleteNoticeById")
    public RpcResponse<Integer> deleteNoticeById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(CONTENT_ID_IS_EMPTY);
        }
        NoticeVO.NoticeVo noticeVO = service.getNoticeById(id);
        if (noticeVO == null) {
            return RpcResponse.error(CONTENT_NOT_EXIST);
        }
        return RpcResponse.success(service.deleteNoticeById(id));
    }

    @PostMapping("/getAllNotice")
    public RpcResponse<NoticeVO> getAllNotice(Integer nowPage, Integer pageSize) {
        if (!ParamUtil.checkNumbers(nowPage, pageSize)) {
            return RpcResponse.error(CONTENT_LIMIT_IS_EMPTY);
        }
        return RpcResponse.success(service.getAllNotice(nowPage, pageSize));
    }

    @PostMapping("/getNoticeById")
    public RpcResponse<NoticeVO.NoticeVo> getNoticeById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(CONTENT_ID_IS_EMPTY);
        }
        NoticeVO.NoticeVo noticeVO = service.getNoticeById(id);
        if (noticeVO == null) {
            return RpcResponse.error(CONTENT_NOT_EXIST);
        }
        return RpcResponse.success(service.getNoticeById(id));
    }

    @PostMapping("/updateNoticeById")
    public RpcResponse<Integer> updateNoticeById(Integer id, Integer createUserId, String content) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(CONTENT_ID_IS_EMPTY);
        }
        if (!ParamUtil.checkNumbers(createUserId)) {
            return RpcResponse.error(CREATE_USER_ID_IS_EMPTY);
        }
        if (!ParamUtil.checkString(content)) {
            return RpcResponse.error(CONTENT_IS_EMPTY);
        }
        Integer res = service.updateNoticeById(id, createUserId, content);
        if (res == null) {
            return RpcResponse.error(CONTENT_NOT_EXIST);
        }
        return RpcResponse.success(res);
    }
}
