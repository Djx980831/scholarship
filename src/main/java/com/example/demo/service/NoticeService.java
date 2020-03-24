package com.example.demo.service;

import com.example.demo.vo.response.NoticeVO;

public interface NoticeService {

    Integer addNotice(Integer createUserId, String content);

    Integer deleteNoticeById(Integer id);

    NoticeVO getAllNotice(Integer nowPage, Integer pageSize);

    NoticeVO getNoticeById(Integer id);

    Integer updateNoticeByid(Integer id, Integer createUserId, String content);
}
