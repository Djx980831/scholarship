package com.example.demo.service.impl;

import com.example.demo.entity.Notice;
import com.example.demo.mapper.NoticeMapper;
import com.example.demo.service.NoticeService;
import com.example.demo.util.PageInfo;
import com.example.demo.vo.request.NoticeVORequest;
import com.example.demo.vo.response.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-24 22:16
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper mapper;

    @Override
    public Integer addNotice(Integer createUserId, String content) {
        NoticeVORequest request = new NoticeVORequest();
        request.setContent(content);
        request.setCreateUserId(createUserId);

        mapper.addNotice(request);

        return request.getId();
    }

    @Override
    public Integer deleteNoticeById(Integer id) {
        NoticeVO.NoticeVo noticeVO = getNoticeById(id);
        if (noticeVO == null) {
            return null;
        }
        mapper.deleteNoticeById(id);
        return id;
    }

    @Override
    public NoticeVO getAllNotice(Integer nowPage, Integer pageSize) {
        List<Notice> noticeList = mapper.getAllNotice(nowPage - 1, pageSize);
        int count = mapper.getCount();

        NoticeVO noticeVO = new NoticeVO();
        List<NoticeVO.NoticeVo> noticeVoList = new ArrayList<>(10);

        for (Notice notice : noticeList) {
            NoticeVO.NoticeVo vo = new NoticeVO.NoticeVo();
            vo.setId(notice.getId());
            vo.setContent(notice.getContent());
            vo.setCreateTime(notice.getCreateTime().toString().substring(0,10));

            noticeVoList.add(vo);
        }
        noticeVO.setNoticeVoList(noticeVoList);
        PageInfo pageInfo = new PageInfo(count, nowPage, pageSize);
        noticeVO.setPageInfo(pageInfo);

        return noticeVO;
    }

    @Override
    public NoticeVO.NoticeVo getNoticeById(Integer id) {
        Notice notice = mapper.getNoticeById(id);
        if (notice == null) {
            return null;
        }

        NoticeVO.NoticeVo vo = new NoticeVO.NoticeVo();
        vo.setContent(notice.getContent());
        vo.setCreateTime(notice.getCreateTime().toString().substring(0,10));
        vo.setId(notice.getId());

        return vo;
    }

    @Override
    public Integer updateNoticeById(Integer id, Integer createUserId, String content) {
       Notice notice = mapper.getNoticeById(id);
        if (notice == null) {
            return null;
        }

        NoticeVORequest request = new NoticeVORequest();
        request.setId(id);
        request.setContent(content);
        request.setCreateUserId(createUserId);

        mapper.updateNoticeById(request);
        return id;
    }
}
