package com.example.demo.mapper;

import com.example.demo.entity.Notice;
import com.example.demo.vo.request.NoticeVORequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface NoticeMapper {

    Integer addNotice(NoticeVORequest noticeVORequest);

    Integer deleteNoticeById(Integer id);

    Integer getCount();

    List<Notice> getAllNotice(@RequestParam("nowPage") Integer nowPage, @RequestParam("pageSize") Integer pageSize);

    Notice getNoticeById(Integer id);

    Integer updateNoticeById(NoticeVORequest noticeVORequest);
}
