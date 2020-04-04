package com.example.demo.vo.response;

import com.example.demo.util.PageInfo;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-24 22:02
 */
@Data
public class NoticeVO {
    private PageInfo pageInfo;
    private List<NoticeVo> noticeVoList;

    @Data
    public static class NoticeVo{
        private Integer id;
        private String content;
        private String createTime;
    }
}
