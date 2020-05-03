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
 * @Date 2020-03-31 23:12
 */
@Data
public class CommentVO {

    private PageInfo pageInfo;
    private List<CommentVo> commentVoList;

    @Data
    public static class CommentVo{
        private Integer id;
        private Integer commentUserId;
        private String userName;
        private String comment;
        private String createTime;
    }
}
